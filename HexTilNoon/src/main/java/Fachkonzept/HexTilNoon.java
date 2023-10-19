/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Fachkonzept;

//import Fachkonzept.Interpreter;
import GUI.Editor;
/**
 *
 * @author user
 */
public class HexTilNoon {

    public static void main(String[] args) {
        /*Interpreter i = new Interpreter();

        String[] prog = i.loadProgrammFromFile("C:\\Users\\user\\Desktop\\test.txt");
        
        i.execute(prog);*/
        Editor g = new Editor();
        g.setTitle("HexTilNoon - Editor");
        g.setVisible(true);
        g.pack();
    }
}
