/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bitext2;

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
public class BIText2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] oraciones = new String[100000];
        String txt="";

        
        /*Lector del archivo txt a clasificar, cambiar la dirección donde se encuentre el archivo*/
        BufferedReader br = null;
        try {
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\twain.txt"));
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\motivational.txt"));
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\libro.txt"));
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\HP.txt"));
            //br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\libro2.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
    String line;
            try {
                while ((line = br.readLine()) != null) {
                    txt += line + "";
                }       } catch (IOException ex) {
                Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
     /*Lector de las lista de Verbos Positivos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/
        String[] verbp= new String[5000];
        int a = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\verPositivo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    verbp[a] = line;
                    a++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
       
       /*Lector de las lista de Verbos Negativos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/ 
        String[] verbn= new String[5000];
        int b = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\verNegativo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    b++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
        /*Lector de las lista de Adjetivo Negativos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/
        String[] adjn= new String[5000];
        int c = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\adjNegativo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    adjn[c] = line;
                    c++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
        /*Lector de las lista de Adjetivos Positivos se debe cambiar la direccion donde se encuentre el archivo verPositivo.txt
     se puede descargar elm archivo en el directorio ListasVerbosAdjetivos en GitHub*/
        String[] adjp= new String[5000];
        int d = 0;
     try {
            br = new BufferedReader(new FileReader("C:\\Users\\Lein\\Documents\\BI\\adjPositivo.txt"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                while ((line = br.readLine()) != null) {
                    adjp[d] = line;
                    d++;
                }       } catch (IOException ex) {
                Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
            }   
       
       
        
       /*Separador de oraciones del txt a clasificar por medio del token "."*/ 
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
        int positive = 0;
        int negative = 0;
        
        
        /*Implementacion 2: Se ca añadiendo un contador de positivos y negativos cada vez que encuentra una coincidencia 
         dentro de cada oración*/
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
                    positive += 1;
                    
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
                    negative += 1;
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
                     negative += 1;
                    
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
                    positive +=1;
                }
                
            }
            
            /*Si no se encuentran coincidencias dentro de las oraciones se la clasifica como neutra*/
            if(vp == 0 && vn == 0 && an == 0 && ap == 0)
            {
                clase = "neutro";
                positive = 0;
                negative = 0;
            }
            else
            {
                /*Compara el numero de positivos con negativos, se clasifica con el resultado mayor, 
                REGLA ESPECIAL: Si hay el mismo numero de positivos y negativos se la marca como negativo*/
                if(positive > negative)
                {
                    clase = "positive";
                }
                else if(positive < negative)
                {
                    clase = "negative";
                }
                else if (positive == negative)
                {
                    clase = "negative";
                }
            }
            
            
            //Guardar Resultados
            Resp[r] = vp + "," + vn + "," + an + "," + ap + "," + clase;
            
            //Reiniciar Variables auxiliares
            vp = 0;
            vn = 0;
            an = 0;
            ap = 0;
            positive = 0;
            negative = 0;
            clase = "";
            
            
        }
         
        
      
        

        
      //Crear Datos del arrf  
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
        
       
        
       /*Se Guardadn los datos del srff en un archivo, se recomienda crear un archivo arff en blanco antes de correr el 
        programa, cambiar la direccion del directorio donde se encuentra el archivo*/ 
        BufferedWriter outputWriter = null;
        try {
            //outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\Lein\\Documents\\BI\\Test2\\separado.arff"));
            //outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\Lein\\Documents\\BI\\Test2\\testfin.arff"));
            outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\Lein\\Documents\\BI\\Test2\\test2.arff"));
        } catch (IOException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
            }
  //}
        try {  
            outputWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {  
            outputWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(BIText2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
