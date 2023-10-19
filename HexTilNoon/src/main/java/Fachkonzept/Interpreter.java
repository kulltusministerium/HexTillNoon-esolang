/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachkonzept;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Interpreter {        
    private byte[] cells;
    private int iProgCounter;
    private int iDataPointer;
    private String[] asciiZeichen;
    private String[] asciiCode;
    
    public Interpreter()
    {
        cells = new byte[256];
        iProgCounter = 0;
        iDataPointer = 0;
        asciiZeichen = new String[111];
        asciiCode = new String[111];
        
        loadAscii();
    }
    
    public void reset()
    {
        for (int i = 0; i < cells.length; i++) {
            cells[i] = 0;
        }
        iProgCounter = 0;
        iDataPointer = 0;
    }
    
    public String[] loadProgrammFromFile(String path)
    {
        String[] programm = new String[2000];
        
        for (int i = 0; i < programm.length; i++) {
            programm[i] = "FF";
        }
        
        int iZaehler = 0;
        
        try
        {
            // Open the file
            FileInputStream fstream = new FileInputStream(path);            
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                programm[iZaehler] = strLine;
                iZaehler++;
            }
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
        }
        
        return programm;
    }
    
    public void loadAscii()
    {
        asciiZeichen[0] = "!";
        asciiCode[0] = "21";
        asciiZeichen[1] = "\"";
        asciiCode[1] = "22";
        asciiZeichen[2] = "#";
        asciiCode[2] = "23";
        asciiZeichen[3] = "$";
        asciiCode[3] = "24";
        asciiZeichen[4] = "%";
        asciiCode[4] = "25";
        asciiZeichen[5] = "&";
        asciiCode[5] = "26";
        asciiZeichen[6] = "'";
        asciiCode[6] = "27";        
        asciiZeichen[7] = "(";
        asciiCode[7] = "28";
        asciiZeichen[8] = ")";
        asciiCode[8] = "29";
        asciiZeichen[9] = "*";
        asciiCode[9] = "2A";
        asciiZeichen[10] = "+";
        asciiCode[10] = "2B";
        asciiZeichen[11] = ",";
        asciiCode[11] = "2C";
        asciiZeichen[12] = "-";
        asciiCode[12] = "2D";
        asciiZeichen[13] = ".";
        asciiCode[13] = "2E";
        asciiZeichen[14] = "/";
        asciiCode[14] = "2F";
        asciiZeichen[15] = "0";
        asciiCode[15] = "30";
        asciiZeichen[16] = "1";
        asciiCode[16] = "31";
        asciiZeichen[17] = "2";
        asciiCode[17] = "32";
        asciiZeichen[18] = "3";
        asciiCode[18] = "33";
        asciiZeichen[19] = "4";
        asciiCode[19] = "34";
        asciiZeichen[20] = "5";
        asciiCode[20] = "35";
        asciiZeichen[21] = "6";
        asciiCode[21] = "36";
        asciiZeichen[22] = "7";
        asciiCode[22] = "37";
        asciiZeichen[23] = "8";
        asciiCode[23] = "38";
        asciiZeichen[24] = "9";
        asciiCode[24] = "39";
        asciiZeichen[25] = ":";
        asciiCode[25] = "3A";
        asciiZeichen[26] = "<";
        asciiCode[26] = "3C";
        asciiZeichen[27] = "=";
        asciiCode[27] = "3D";
        asciiZeichen[28] = ">";
        asciiCode[28] = "3E";
        asciiZeichen[29] = "?";
        asciiCode[29] = "3F";
        asciiZeichen[30] = "@";
        asciiCode[30] = "40";
        asciiZeichen[31] = "A";
        asciiCode[31] = "41";
        asciiZeichen[32] = "B";
        asciiCode[32] = "42";
        asciiZeichen[33] = "C";
        asciiCode[33] = "43";
        asciiZeichen[34] = "D";
        asciiCode[34] = "44";        
        asciiZeichen[35] = "E";
        asciiCode[35] = "45";
        asciiZeichen[36] = "F";
        asciiCode[36] = "46";
        asciiZeichen[37] = "G";
        asciiCode[37] = "47";
        asciiZeichen[38] = "H";
        asciiCode[38] = "48";
        asciiZeichen[39] = "I";
        asciiCode[39] = "49";
        asciiZeichen[40] = "J";
        asciiCode[40] = "4A";
        asciiZeichen[41] = "K";
        asciiCode[41] = "4B";        
        asciiZeichen[42] = "L";
        asciiCode[42] = "4C";
        asciiZeichen[43] = "M";
        asciiCode[43] = "4D";
        asciiZeichen[44] = "N";
        asciiCode[44] = "4E";
        asciiZeichen[45] = "O";
        asciiCode[45] = "4F";
        asciiZeichen[46] = "P";
        asciiCode[46] = "50";
        asciiZeichen[47] = "Q";
        asciiCode[47] = "51";
        asciiZeichen[48] = "R";
        asciiCode[48] = "52";
        asciiZeichen[49] = "S";
        asciiCode[49] = "53";
        asciiZeichen[50] = "T";
        asciiCode[50] = "54";
        asciiZeichen[51] = "U";
        asciiCode[51] = "55";
        asciiZeichen[52] = "V";
        asciiCode[52] = "56";
        asciiZeichen[53] = "W";
        asciiCode[53] = "57";
        asciiZeichen[54] = "X";
        asciiCode[54] = "58";
        asciiZeichen[55] = "Y";
        asciiCode[55] = "59";
        asciiZeichen[56] = "Z";
        asciiCode[56] = "5A";
        asciiZeichen[57] = "[";
        asciiCode[57] = "5B";
        asciiZeichen[58] = "\\";
        asciiCode[58] = "5C";
        asciiZeichen[59] = "]";
        asciiCode[59] = "5D";
        asciiZeichen[60] = "^";
        asciiCode[60] = "5E";
        asciiZeichen[61] = "_";
        asciiCode[61] = "5F";
        asciiZeichen[62] = "`";
        asciiCode[62] = "60";
        asciiZeichen[63] = "a";
        asciiCode[63] = "61";
        asciiZeichen[64] = "b";
        asciiCode[64] = "62";
        asciiZeichen[65] = "c";
        asciiCode[65] = "63";
        asciiZeichen[66] = "d";
        asciiCode[66] = "64";
        asciiZeichen[67] = "e";
        asciiCode[67] = "65";
        asciiZeichen[68] = "f";
        asciiCode[68] = "66";
        asciiZeichen[69] = "g";
        asciiCode[69] = "67";        
        asciiZeichen[70] = "h";
        asciiCode[70] = "68";
        asciiZeichen[71] = "i";
        asciiCode[71] = "69";
        asciiZeichen[72] = "j";
        asciiCode[72] = "6A";
        asciiZeichen[73] = "k";
        asciiCode[73] = "6B";
        asciiZeichen[74] = "l";
        asciiCode[74] = "6C";
        asciiZeichen[75] = "m";
        asciiCode[75] = "6D";
        asciiZeichen[76] = "n";
        asciiCode[76] = "6E";
        asciiZeichen[77] = "o";
        asciiCode[77] = "6F";
        asciiZeichen[78] = "p";
        asciiCode[78] = "70";
        asciiZeichen[79] = "q";
        asciiCode[79] = "71";
        asciiZeichen[80] = "r";
        asciiCode[80] = "72";
        asciiZeichen[81] = "s";
        asciiCode[81] = "73";
        asciiZeichen[82] = "t";
        asciiCode[82] = "74";
        asciiZeichen[83] = "u";
        asciiCode[83] = "75";
        asciiZeichen[84] = "v";
        asciiCode[84] = "76";
        asciiZeichen[85] = "w";
        asciiCode[85] = "77";
        asciiZeichen[86] = "x";
        asciiCode[86] = "78";
        asciiZeichen[87] = "y";
        asciiCode[87] = "79";
        asciiZeichen[88] = "z";
        asciiCode[88] = "7A";
        asciiZeichen[89] = "{";
        asciiCode[89] = "7B";
        asciiZeichen[90] = "|";
        asciiCode[90] = "7C";
        asciiZeichen[91] = "}";
        asciiCode[91] = "7D";
        asciiZeichen[92] = "~";
        asciiCode[92] = "7E";
        asciiZeichen[93] = "„";
        asciiCode[93] = "91";
        asciiZeichen[94] = "‟";
        asciiCode[94] = "92";        
        asciiZeichen[95] = "“";
        asciiCode[95] = "93";
        asciiZeichen[96] = "”";
        asciiCode[96] = "94";
        asciiZeichen[97] = "•";
        asciiCode[97] = "95";
        asciiZeichen[98] = "˜˜~˜";
        asciiCode[98] = "98";
        asciiZeichen[99] = "€";
        asciiCode[99] = "80";
        asciiZeichen[100] = "£";
        asciiCode[100] = "A3";
        asciiZeichen[101] = "¥";
        asciiCode[101] = "A5";        
        asciiZeichen[102] = "©";
        asciiCode[102] = "A9";
        asciiZeichen[103] = "™";
        asciiCode[103] = "99";
        asciiZeichen[104] = "°";
        asciiCode[104] = "B0";
        asciiZeichen[105] = "˜˜~˜";
        asciiCode[105] = "98";
        asciiZeichen[106] = "¡";
        asciiCode[106] = "A1";
        asciiZeichen[107] = "¿";
        asciiCode[107] = "BF";
        asciiZeichen[108] = ";";
        asciiCode[108] = "3B";
        asciiZeichen[109] = " ";
        asciiCode[109] = "20"; 
        asciiZeichen[110] = "\n";
        asciiCode[110] = "1F";
    }
    
    public void printAllAscii()
    {
        for (int i = 0; i < asciiCode.length; i++) {
            if(asciiZeichen[i] != null)
                System.out.println(asciiCode[i] + ": " + asciiZeichen[i]);
        }
    }
    
    public byte[] returnCells()
    {
        return cells;
    }
    
    public String[] execute(String[] progZeilen)
    {
        String[] rueck = new String[progZeilen.length];
        byte addressDest;
        byte addressLoc;
        String[] zeilenSplit;
        int valI = 0;
        
        for (int i = 0; i < progZeilen.length; i++) {                 
            try
            {
                zeilenSplit = progZeilen[i].split(" ");
                switch(zeilenSplit[0])
                {
                    case "00"://Set value of active adress
                        cells[iDataPointer] = Byte.valueOf(zeilenSplit[1]);                    
                        break;
                    case "01"://change active adress
                        iDataPointer = Byte.valueOf(zeilenSplit[1]);
                        break;
                    case "02"://prints value of active cell
                        //System.out.println(cells[iDataPointer]);
                        rueck[i] = String.valueOf(cells[iDataPointer]);
                        break;
                    case "03"://adds value of second mentioned address to first mentioned into first one
                        addressDest = Byte.valueOf(zeilenSplit[1]);
                        addressLoc = Byte.valueOf(zeilenSplit[2]);
                        cells[addressDest] = (byte) (cells[addressDest] + cells[addressLoc]);     
                        //rueck[i] = String.valueOf(cells[addressDest]);
                        break;
                    case "04"://subs value of second mentioned address to first mentioned into first one
                        addressDest = Byte.valueOf(zeilenSplit[1]);
                        addressLoc = Byte.valueOf(zeilenSplit[2]);                                        
                        cells[addressDest] = (byte) (cells[addressDest] - cells[addressLoc]);
                        //rueck[i] = String.valueOf(cells[addressDest]);
                        break;
                    case "05"://multiplies value of second mentioned address to first mentioned into first one
                        addressDest = Byte.valueOf(zeilenSplit[1]);
                        addressLoc = Byte.valueOf(zeilenSplit[2]);                                        
                        cells[addressDest] = (byte) (cells[addressDest] * cells[addressLoc]);
                        //rueck[i] = String.valueOf(cells[addressDest]);
                        break;
                    case "06"://divide value of second mentioned address to first mentioned into first one
                        addressDest = Byte.valueOf(zeilenSplit[1]);
                        addressLoc = Byte.valueOf(zeilenSplit[2]);                                        
                        cells[addressDest] = (byte) (cells[addressDest] / cells[addressLoc]);
                        //rueck[i] = String.valueOf(cells[addressDest]);
                        break;
                    case "07"://pows
                        addressDest = Byte.valueOf(zeilenSplit[1]);
                        addressLoc = Byte.valueOf(zeilenSplit[2]);
                        cells[addressDest] = (byte) Math.pow(cells[addressDest],cells[addressLoc]);
                        //rueck[i] = String.valueOf(cells[addressDest]);
                        break;
                    case "08":
                        for (int e = 0; e < asciiCode.length; e++) {
                            if(zeilenSplit[1].equals(asciiCode[e]))
                            {
                                //System.out.print(asciiZeichen[e]);
                                rueck[i] = asciiZeichen[e];
                                break;
                            }
                        }
                        break;
                    case "09":
                        //jump programm-code
                        int rueckgang = Integer.parseInt(zeilenSplit[1]);
                        if(i>rueckgang)
                        {
                            i = i - rueckgang;
                        }
                        break;
                    case "0A":
                        //break-condition for jump
                        byte val = Byte.parseByte(zeilenSplit[1]);
                        byte addr = Byte.parseByte(zeilenSplit[2]);
                        if(cells[addr] == val)
                            i = i + 1;
                        break;
                    case "0B":
                        //input
                        cells[iDataPointer] = Byte.valueOf(zeilenSplit[1]);
                        //rueck[i] = String.valueOf(cells[iDataPointer]);
                        break;
                    case "0C": //increment
                        cells[iDataPointer] = (byte) (cells[iDataPointer]+1);
                        break;
                    case "0D"://decrement
                        cells[iDataPointer] = (byte) (cells[iDataPointer]-1);
                        break;
                    case "0E"://increments current data-segment
                        iDataPointer -= 1;                         
                        break;
                    case "0F"://increments current data-segment
                        iDataPointer += 1;
                        break;
                    case "10":      
                        
                        break;
                    case "11":
                        
                        break;
                    case "12":
                        
                        break;
                    case "13":
                        
                        break;
                    case "14":
                        
                        break;
                    case "15":
                        
                        break;
                    case "16":
                        
                        break;
                    case "17":
                        
                        break;
                    case "18":
                        
                        break;
                    case "19":
                        
                        break;
                    case "1A":
                        
                        break;
                    case "1B":
                        
                        break;
                    case "1C":
                        
                        break;
                    case "1D":
                        
                        break;
                    case "1E":
                        
                        break;
                    case "1F":
                        
                        break;
                    case "FF":
                        //reserved as anchor for jump-commands (= no-operation command)
                        break;
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,i + " " + e.getMessage(),"Error",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return rueck;
    }
}
