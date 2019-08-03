package gb.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
    private Vector<ClientHandler> clients;
    private Logger logger;
    private Handler handler;

    public Server(Logger logger, Handler handler) throws SQLException {
        clients = new Vector<>();
        this.logger = logger;
        this.handler = handler;
        ServerSocket server = null;
        Socket socket = null;
        try {
            AuthService.connect();
            server = new ServerSocket(8189);
            logger.log(Level.INFO, "Сервер запущен. Ожидаем клиентов...");
            System.out.println("Сервер запущен. Ожидаем клиентов...");
            while (true) {
                socket = server.accept();
                logger.log(Level.INFO, "Клиент подключился");
                System.out.println("Клиент подключился");
                 new ClientHandler(this, socket);
               // clients.add(new ClientHandler(this, socket));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                logger.log(Level.INFO, "Клиент отключился.");
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
                e.printStackTrace();
            }
            try {
                server.close();
                logger.log(Level.INFO, "Сервер остановлен.");
            } catch (IOException e) {
                logger.log(Level.SEVERE, e.getMessage());
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadcastMsg(ClientHandler from, String msg) {
        for (ClientHandler o : clients) {
            if(!o.checkBlackList(from.getNick())) {
                logger.log(Level.INFO, "Отправка сообщения пользователю " + o.getNick() + ": " + msg);
                o.sendMsg(msg);
            }
        }
    }

    public boolean isNickBusy(String nick) {
        boolean res = false;
        for (ClientHandler o: clients){
            if(o.getNick().equals(nick)) {
                res = true;
            }
        }
        if(res){
            logger.log(Level.INFO, "Имя клиента занято");
        }
        else{
            logger.log(Level.INFO, "Имя клиента свободно");
        }
        return res;
    }

    public void broadcastClientList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientList ");
        for (ClientHandler o: clients) {
            sb.append(o.getNick() + " ");
        }
        String out = sb.toString();
        logger.log(Level.INFO, "Список пользователей - " + out);

        for(ClientHandler o: clients) {
            o.sendMsg(out);
        }
    }

    public void sendPersonalMsg(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler o: clients) {
            if(o.getNick().equals(nickTo)) {
                o.sendMsg("from " + from.getNick() + ": " + msg);
                from.sendMsg("to " + nickTo + ": " + msg);
                logger.log(Level.INFO, "Отправка личного сообщения - " + "from " + from.getNick() + " to " + nickTo + ": " + msg);
                return;
            }
        }
        from.sendMsg("Клиент с ником " + nickTo + ": " + msg);
        logger.log(Level.INFO, "Отправка личного сообщения - " + "Клиент с ником " + nickTo + ": " + msg);
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientList();
    }
}
