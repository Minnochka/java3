import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrClassLast4 {

        private ArrClass arrClass;

        @Before
        public void newArrClass(){
            int[] arr = {1,4};
            this.arrClass = new ArrClass(arr);
            System.out.println("start test");
        }

        @Test(expected = RuntimeException.class)
        public void arrClassTest1() {
            Assert.assertArrayEquals(new int[]{}, arrClass.lastFourArr(new int[]{1,6,7}));
        }

        @Test
        public void arrClassTest2() {
            Assert.assertArrayEquals(new int[]{5}, arrClass.lastFourArr(new int[]{8,6,79,0,4,5}));
        }

        @Test
        public void arrClassTest3() {
            Assert.assertArrayEquals(new int[]{}, arrClass.lastFourArr(new int[]{6,7,4,1,0,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,7,4}));
        }

        @Test
        public void arrClassTest4() {
            Assert.assertArrayEquals(new int[]{6,7,7,3}, arrClass.lastFourArr(new int[]{4,6,7,7,3}));
        }

        @Test(expected = RuntimeException.class)
        public void arrClassTest5() {
            Assert.assertArrayEquals(new int[]{}, arrClass.lastFourArr(new int[]{}));
        }

        @Test
        public void arrClassTest6() {
            Assert.assertArrayEquals(new int[]{3}, arrClass.lastFourArr(new int[]{4,6,4,7,4,7,4,3}));
        }

        @After
        public void finishArrClass(){
            System.out.println("end test");
        }
    }


