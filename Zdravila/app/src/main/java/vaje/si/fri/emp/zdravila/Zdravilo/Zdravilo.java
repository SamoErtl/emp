package vaje.si.fri.emp.zdravila.Zdravilo;

/**
 * Created by Hisa on 09/01/2018.
 */

public class Zdravilo {

    private String Name;
    private String Id_manu;
    private String NameLat;
    private String Inst;
    private String Descr;

    public String getName() {
        return Name;
    }

    public String getId_manu() {
        return Id_manu;
    }

    public String getNameLat() {
        return NameLat;
    }

    public String getInst() {
        return Inst;
    }

    public String getDescr() {
        return Descr;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setId_manu(String id_manu) {
        Id_manu = id_manu;
    }

    public void setNameLat(String nameLat) {
        NameLat = nameLat;
    }

    public void setInst(String inst) {
        Inst = inst;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }
}
