package vaje.si.fri.emp.zdravila;

/**
 * Created by jjmse on 06/01/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pojo {

    @SerializedName("Descr")
    @Expose
    private String descr;
    @SerializedName("Id_manu")
    @Expose
    private String idManu;
    @SerializedName("Inst")
    @Expose
    private String inst;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("NameLat")
    @Expose
    private String nameLat;

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getIdManu() {
        return idManu;
    }

    public void setIdManu(String idManu) {
        this.idManu = idManu;
    }

    public String getInst() {
        return inst;
    }

    public void setInst(String inst) {
        this.inst = inst;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameLat() {
        return nameLat;
    }

    public void setNameLat(String nameLat) {
        this.nameLat = nameLat;
    }

}

