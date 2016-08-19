/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitext;

/**
 *
 * @author Lein
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
public class BIText {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] oraciones = new String[100000];
        String txt="";

        
        /*Lector de archivos, se debe cambiar la direccion donde se encuentre el txt que desee clasificar*/
        BufferedReader br = null;
        try {
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\twain.txt"));
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\motivational.txt"));
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\libro.txt"));
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\HP.txt"));
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\libro2.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
    String line;
            try {
                while ((line = br.readLine()) != null) {
                    txt += line + "";
                }       } catch (IOException ex) {
                Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
    /*Lector de las lista de Verbos Positivos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/
        String[] verbp= new String[5000];
        int a = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\verPositivo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    verbp[a] = line;
                    a++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
       
       /*Lector de las lista de Verbos Negativos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/ 
        String[] verbn= new String[5000];
        int b = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\verNegativo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    verbn[b] = line;
                    b++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
        
        /*Lector de las lista de Adjetivos Negativos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/
        String[] adjn= new String[5000];
        int c = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\adjNegativo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    adjn[c] = line;
                    c++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
        
        /*Lector de las lista de Adjetivos Positivos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/
        String[] adjp= new String[5000];
        int d = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\adjPositivo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    adjp[d] = line;
                    d++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
            }   
     
        /*Separador de las oraciones del texto por token "."*/
        int i = 0;
        String aux = "";
        StringTokenizer st = new StringTokenizer(txt, ".");
        while(st.hasMoreTokens()) {
            
            aux = st.nextToken();
            if(aux.length() > 5)
            {
            oraciones[i] = aux;
            i++;
            }
            

        }
        
        
        String[] splitted;
        boolean search;
        int vp = 0;
        int vn = 0;
        int an = 0;
        int ap = 0;
        String clase = "";
        
        String[] Resp = new String[i];
        String vvp = "";
        String vvn = "";
        String aan = "";
        String aap = "";
        
        String sign = "";
        char num;
        int asd = 1;
        
        
        /*Clasificador: Por cada palabra en la lista encontrada en cada oración se añade al String sign el char + 
        si se halla un verbo o adjetivo positivo o un - si se encuentran verbos o adjetivos negativos*/
        for(int r=0; r<i; r++)
        {
            for(int f=0; f<a; f++)
            {
                splitted = oraciones[r].split("\\b+");
                search = Arrays.asList(splitted).contains(verbp[f]);
                if(search == true)
                {
                    vp++;
                    vvp = verbp[f];
                    sign += "+";
                    
                }
                
            }
            for(int f=0; f<b; f++)
            {
                splitted = oraciones[r].split("\\b+");
                search = Arrays.asList(splitted).contains(verbn[f]);
                if(search == true)
                {
                    vn++;
                    vvn = verbn[f];
                    sign += "-";
                }
                
            }
            for(int f=0; f<c; f++)
            {
                splitted = oraciones[r].split("\\b+");
                search = Arrays.asList(splitted).contains(adjn[f]);
                if(search == true)
                {
                    an++;
                    aan = adjn[f];
                    sign += "-";
                    
                }
                
            }
            for(int f=0; f<d; f++)
            {
                splitted = oraciones[r].split("\\b+");
                search = Arrays.asList(splitted).contains(adjp[f]);
                if(search == true)
                {
                    ap++;
                    aap = adjp[f];
                    sign += "+";
                }
                
            }
            
            /*Si no se hallan verbos o adjetivos se clasifica como neutro*/
            if(vp == 0 && vn == 0 && an == 0 && ap == 0)
            {
                clase = "neutro";
                asd = 0;
            }
            else
            {
                /*Dentro de los signos guardo en una variable int los valores de la cadena sign, calculo para ver si este 
                 es positivo o negativo, dependiendo del resultado determino la clase*/
                for(int x = 0; x<sign.length();x++)
                {
                    num = sign.charAt(x);
                    if(num == '+')
                    {
                        asd = asd * 1;
                    }
                    if(num == '-')
                    {
                        asd = asd * -1;
                    }
                }

                if(asd > 0)
                {
                    clase = "positive";
                }
                else
                {
                    clase = "negative";
                }
            }
            
          
            Resp[r] = vp + "," + vn + "," + an + "," + ap + "," + clase;
            
            /*Reiniciar Variables*/
            vp = 0;
            vn = 0;
            an = 0;
            ap = 0;
            asd = 1;
            sign = "";
            clase = "";
            
            
        }
         
       
        
     /*Genero los datos del arff*/
        String lel = "@RELATION value\n\n"
                + "@ATTRIBUTE positiveverb REAL\n"
                + "@ATTRIBUTE negativeverb REAL\n"
                + "@ATTRIBUTE negativeadjective REAL\n"
                + "@ATTRIBUTE positiveadjective REAL\n"
                + "@ATTRIBUTE class {positive, negative, neutro}"
                + "\n\n@DATA\n";
        for(int z = 0; z<i; z++)
        {
            lel = lel + Resp[z]+ "\n";
            
        }
        
        System.out.println(lel);
        
        
        /*Guardo los datos en el arff, se cambia dirección y nombre del archivo, se recomienda crear un arff en blanco en 
         en el directorio recomendado antes*/
        BufferedWriter outputWriter = null;
        try {
            //outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\Lein\\Documents\\BI\\Test1\\separado.arff"));
            outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\Lein\\Documents\\BI\\Test1\\testfin.arff"));
            //outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\Lein\\Documents\\BI\\Test1\\test4.arff"));
        } catch (IOException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
  //for (int k = 0; k < i; k++) {
            try {
                // Maybe:
                //outputWriter.write("\nOracion "+ (k+1) + "\n");
                outputWriter.write(lel+"\n");
                // Or:
                /*outputWriter.write(Integer.toString(oraciones[i]);
                outputWriter.newLine();*/
            } catch (IOException ex) {
                Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
            }
  //}
        try {  
            outputWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {  
            outputWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(BIText.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
