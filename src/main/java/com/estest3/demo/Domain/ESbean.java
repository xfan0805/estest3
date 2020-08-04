package com.estest3.demo.Domain;

public class ESbean {

    //private String id;
    private String uuid;
    private String subuuid;
    private String title;
    private String en_title;
    private String standard_number;
    private String replace_standard;
    private String pubdate;
    private String implement_date;
    private String pdf;
    private String drafting_unit;
    private String drafter;
    private String scope;
    private String reference_file;
    private String reference_file_pdf;
    private String reference_file_number;
    private String term_definition;
    private String request;

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public String getReference_file_pdf() {
        return reference_file_pdf;
    }

    public void setReference_file_pdf(String reference_file_pdf) {
        this.reference_file_pdf = reference_file_pdf;
    }

    public String getDrafting_unit() {
        return drafting_unit;
    }

    public void setDrafting_unit(String drafting_unit) {
        this.drafting_unit = drafting_unit;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSubuuid() {
        return subuuid;
    }

    public void setSubuuid(String subuuid) {
        this.subuuid = subuuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEn_title() {
        return en_title;
    }

    public void setEn_title(String en_title) {
        this.en_title = en_title;
    }

    public String getStandard_number() {
        return standard_number;
    }

    public void setStandard_number(String standard_number) {
        this.standard_number = standard_number;
    }

    public String getReplace_standard() {
        return replace_standard;
    }

    public void setReplace_standard(String replace_standard) {
        this.replace_standard = replace_standard;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getImplement_date() {
        return implement_date;
    }

    public void setImplement_date(String implement_date) {
        this.implement_date = implement_date;
    }

    public String getDrafter() {
        return drafter;
    }

    public void setDrafter(String drafter) {
        this.drafter = drafter;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getReference_file() {
        return reference_file;
    }

    public void setReference_file(String reference_file) {
        this.reference_file = reference_file;
    }

    public String getReference_file_number() {
        return reference_file_number;
    }

    public void setReference_file_number(String reference_file_number) {
        this.reference_file_number = reference_file_number;
    }

    public String getTerm_definition() {
        return term_definition;
    }

    public void setTerm_definition(String term_definition) {
        this.term_definition = term_definition;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    @Override
    public String toString() {
        return "{" +
                " \"title\":\"" + title + '"' +
                ", \"en_title\":\"" + en_title + '"' +
                ", \"standard_number\":\"" + standard_number + '"' +
                ", \"replace_standard\":\"" + replace_standard + '"' +
                ", \"pubdate\":\"" + pubdate + '"' +
                ", \"implement_date\":\"" + implement_date + '"' +
                ", \"pdf\":\"" + pdf + '"' +
                ", \"drafting_unit\":\"" + drafting_unit + '"' +
                ", \"drafter\":\"" + drafter + '"' +
                ", \"scope\":\"" + scope + '"' +
                ", \"reference_file\":\"" + reference_file + '"' +
                ", \"reference_file_pdf\":\"" + reference_file_pdf + '"' +
                ", \"reference_file_number\":\"" + reference_file_number + '"' +
                ", \"term_definition\":\"" + term_definition + '"' +
                ", \"request\":\"" + request + '"' +
                '}';



    }
}
