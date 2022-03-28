package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.PointCataloguePage;
import org.junit.Test;

public class PointCatalogueTest extends BaseTest {

 @Test
    public void pointTest(){
     PointCataloguePage pointCataloguePage = new PointCataloguePage();
     pointCataloguePage.point();
     pointCataloguePage.addRandomItem();
 }
}
