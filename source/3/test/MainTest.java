package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;


public class MainTest {
    @Test
    public void testCalc() {
        ViewResult view = new ViewResult(5);
        view.init(90.0);
        Item2d item = new Item2d();
        int ctr = 0;
        item.setXY(0.0, 0.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(90.0, 1.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(180.0, 0.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(270.0, -1.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));

        ctr++;
        item.setXY(360.0, 0.0);
        assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
                view.getItems().get(ctr).equals(item));
    }

    @Test
    public void testRestore() {
        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();
        view1.init(Math.random()*100.0);
        
        try {
            view1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        try {
            view2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        assertEquals(view1.getItems().size(), view2.getItems().size());
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}