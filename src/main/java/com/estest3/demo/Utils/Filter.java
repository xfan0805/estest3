package com.estest3.demo.Utils;

import com.estest3.demo.Domain.ESbean;

import java.util.ArrayList;
import java.util.List;

import com.estest3.demo.Domain.ESbean2;

public class Filter {

    public static List<ESbean2> filter(List<ESbean> eSbeans){

       // System.out.println("filter开始");

        List<ESbean> newESbeans=new ArrayList<>();
        for (ESbean esbean: eSbeans){
            List<String> reference_file_list = new ArrayList<>();
            List<String> reference_file_number_list = new ArrayList<>();
            List<String> reference_file_pdf_list = new ArrayList<>();

            //System.out.println(reference_file_list);

            String uuid = esbean.getUuid();
            String subuuid =esbean.getSubuuid();
            String reference_file = esbean.getReference_file();
            String reference_file_number = esbean.getReference_file_number();
            String reference_file_pdf = esbean.getReference_file_pdf();

            reference_file_list.add("'"+reference_file+"'");
            reference_file_number_list.add("'"+reference_file_number+"'");
            reference_file_pdf_list.add(reference_file_pdf);

            boolean a = false;
            for(ESbean eSbean3 : newESbeans){
                String uuid3 = eSbean3.getUuid();
                if(uuid.equals(uuid3) == true){
                    a = true;
                }
            }

            if (a == true){
                continue;
            }


            for (ESbean esbean2 : eSbeans){
                //System.out.println(esbean2.toString());

                String uuid2 = esbean2.getUuid();
                String subuuid2 = esbean2.getSubuuid();
                String reference_file2 = esbean2.getReference_file();

                String reference_file_number2 = esbean2.getReference_file_number();

                String reference_file_pdf2 = esbean2.getReference_file_pdf();

                if(uuid.equals(uuid2) == true){
                    if (subuuid.equals(subuuid2) == false){

                        reference_file_list.add("'"+reference_file2+"'");
                        reference_file_number_list.add("'"+reference_file_number2+"'");
                        reference_file_pdf_list.add(reference_file_pdf2);
                    }
                }

            }

            esbean.setReference_file(reference_file_list.toString());
            esbean.setReference_file_number(reference_file_number_list.toString());

            String new_reference_file_pdf = reference_file_pdf_list.toString()
                    .replace("{","")
                    .replace("}","")
                    .replace("[","{")
                    .replace("]","}");
            esbean.setReference_file_pdf(new_reference_file_pdf);

            //System.out.println(esbean.toString());

            newESbeans.add(esbean);

        }

        List<ESbean2> newesbeans = new ArrayList<>();
        for (ESbean esbean:newESbeans){
            String newtitle = esbean.getTitle();
            String newen_title = esbean.getEn_title();
            String newstandard_number = esbean.getStandard_number();
            String newreplace_standard = esbean.getReplace_standard();
            String newpubdate = esbean.getPubdate();
            String newimplement_date = esbean.getImplement_date();
            String newpdf = esbean.getPdf();
            String newdrafting_unit = esbean.getDrafting_unit();
            String newdrafter = esbean.getDrafter();
            String newscope = esbean.getScope();
            String newreference_file = esbean.getReference_file();
            String newreference_file_pdf = esbean.getReference_file_pdf();
            String newreference_file_number = esbean.getReference_file_number();
            String newterm_definition = esbean.getTerm_definition();
            String newrequest = esbean.getRequest();

            ESbean2 newesbean = new ESbean2();

            newesbean.setTitle(newtitle);
            newesbean.setEn_title(newen_title);
            newesbean.setStandard_number(newstandard_number);
            newesbean.setReplace_standard(newreplace_standard);
            newesbean.setPubdate(newpubdate);
            newesbean.setImplement_date(newimplement_date);
            newesbean.setPdf(newpdf);
            newesbean.setDrafting_unit(newdrafting_unit);
            newesbean.setDrafter(newdrafter);
            newesbean.setScope(newscope);
            newesbean.setReference_file(newreference_file);
            newesbean.setReference_file_pdf(newreference_file_pdf);
            newesbean.setReference_file_number(newreference_file_number);
            newesbean.setTerm_definition(newterm_definition);
            newesbean.setRequest(newrequest);

            newesbeans.add(newesbean);
        }

        return newesbeans;
    }

}
