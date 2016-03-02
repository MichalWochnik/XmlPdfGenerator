
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MichalPC
 */
public class XmlHolder {

    public XmlHolder() {
        
    }

    
    
    protected List<String> newFields = new ArrayList<String>();
    
    
    public void XmlCreator(String wiType,String client,String region,String country,String legalentity,String 
                docRef,String docType,String fiscalYear,String serialNumber,int 
                pages,String scanCentre,String scanQueue,String scanned,String priority){
    
        this.newFields.add("<SCAN_DATA xmlns=\"http://Capgemini.BPOpen.ScanIndex\">");
        this.newFields.add("<WI-TYPE>" + wiType + "</WI-TYPE>");
        this.newFields.add("<CLIENT>" + client + "</CLIENT>");
        this.newFields.add("<REGION>" + region + "</REGION>");
        this.newFields.add("<COUNTRY>" + country + "</COUNTRY>");
        this.newFields.add("<LEGALENTITY>" + legalentity + "</LEGALENTITY>");
        this.newFields.add("<DOCREF>" + docRef + "</DOCREF>");
        this.newFields.add("<DOCTYPE>" + docType + "</DOCTYPE>");
        this.newFields.add("<FISCALYEAR>" + fiscalYear + "</FISCALYEAR>");
        this.newFields.add("<SERIALNUMBER>" + serialNumber + "</SERIALNUMBER>");
        this.newFields.add("<PAGES>" + pages + "</PAGES>");
        this.newFields.add("<SCANCENTRE>" + scanCentre + "</SCANCENTRE>");
        this.newFields.add("<SCANQUEUE>" + scanQueue + "</SCANQUEUE>");
        this.newFields.add("<SCANNED>" + scanned + "</SCANNED>");
        this.newFields.add("<PRIORITY>" + priority + "</PRIORITY>");
        this.newFields.add("</SCAN_DATA>");
        
        
    }
    
    
    public List<String> xmlListGet(){
        
        return this.newFields;
    }
    
    public void xmlFieldListSet(int arrayIndex, String setToWriteIn){
        
        this.newFields.set(arrayIndex, setToWriteIn);
        
    }
}
