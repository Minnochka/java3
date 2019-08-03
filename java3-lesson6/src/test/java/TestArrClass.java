import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

public class TestArrClass {

    private ArrClass arrClass;

    @Before
    public void newArrClass(){
        int[] arr = {1,4};
        this.arrClass = new ArrClass(arr);
        System.out.println("start test");
    }

    @Test
        public void arrClassTest1() {
            Assert.assertEquals(true, arrClass.CheckArr(new int[]{1,6,7}));
        }

    @Test
    public void arrClassTest2() {
        Assert.assertEquals(true, arrClass.CheckArr(new int[]{8,6,79,0,4,5}));
    }

    @Test
    public void arrClassTest3() {
        Assert.assertEquals(true, arrClass.CheckArr(new int[]{6,7,4,1,0,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,1,7,4}));
    }

    @Test
    public void arrClassTest4() {
        Assert.assertEquals(false, arrClass.CheckArr(new int[]{6,7,7,3}));
    }

    @Test
    public void arrClassTest5() {
        Assert.assertEquals(false, arrClass.CheckArr(new int[]{}));
    }

    @After
    public void finishArrClass(){
        System.out.println("end test");
    }
    }

