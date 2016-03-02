
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MichalPC
 */
public class documentcreator {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, DocumentException, InterruptedException {
        //add fields You need in XML file
        String wiType, client, region, country, legalentity, 
                docRef, docType, fiscalYear, serialNumber, 
                 scanCentre, scanQueue, scanned, priority;
        int pages;
        int howManyDocuments;
        String pathTo;
        Scanner readFromKeyboard = new Scanner(System.in);
        System.out.println("How many documents You need?");
        howManyDocuments = readFromKeyboard.nextInt();
        System.out.println("What is path to Your loremipsum and image(they need to be in one folder)");
        pathTo = readFromKeyboard.next();
        
        //make new string from file
        
        File loremipsum = new File(pathTo + "\\loremipsum");
            FileReader fr = new FileReader(loremipsum);
            BufferedReader bfr = new BufferedReader(fr);
            String linia, loremipsumText = "";
            while((linia = bfr.readLine()) != null){
                loremipsumText+=linia;
            }
        
        
        //
        
        
        
        for(int i = 0; i < howManyDocuments; i++){
            wiType = "Test" + i;
            client = "Test" + i;
            region = "Test" + i;
            country = "Test" + i;
            legalentity = "Test" + i;
            docRef = "Test" + i;
            docType = "Test" + i;
            fiscalYear = "Test" + i;
            serialNumber = "Test" + i;
            pages = i;
            scanCentre = "Test" + i;
            scanQueue = "Test" + i;
            scanned = "Test" + i;
            priority = "Test" + i;
            
        
        //just for loop
            File file = new File("metadata//Test" + i + ".xml");
            
            if(!file.exists()){
                file.createNewFile();
            }
            
            
            XmlHolder santanderList = new XmlHolder();

            santanderList.XmlCreator(wiType, client, region, country, legalentity, docRef, docType, fiscalYear, serialNumber, pages, scanCentre, scanQueue, scanned, priority);
            //pdf creator
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter pw = PdfWriter.getInstance(document, new FileOutputStream("attachments/Test" + i + ".pdf"));
            document.open();
            Anchor anchorTarget = new Anchor("Test" + i);
            Paragraph paragraph1 = new Paragraph();
            paragraph1.add(anchorTarget);
           
            
            
            Image img = Image.getInstance(pathTo + "\\capgemini-logo.jpg");
            document.add(paragraph1);
            document.add(new Paragraph(loremipsumText));
            document.add(img);
            document.close();
            
            
            //end
            FileWriter fw = new FileWriter(file.getAbsolutePath());
            BufferedWriter bw = new BufferedWriter(fw);
            for(String field : santanderList.xmlListGet()){
                bw.write(field);
                bw.write("\n");
            }
            
            bw.close();
            System.out.println("Percentage done: " + (((float)i/(float)howManyDocuments)*100));
           

        }
        System.out.println("DONE!");
        // TODO code application logic here
    }
    
    
    
    
    
}
