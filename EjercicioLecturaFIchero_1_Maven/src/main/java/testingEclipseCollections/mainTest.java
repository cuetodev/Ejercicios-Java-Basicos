package testingEclipseCollections;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

import java.util.ArrayList;
import java.util.List;

public class mainTest {
    public static void main(String[] args) {

        MutableList<String> testList = Lists.mutable.with("hola1", "hola2", "hola3");

        System.out.println(testList.select(elemento -> elemento.equals("hola1")));
    }
}
