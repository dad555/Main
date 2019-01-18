package com.artur;

public class PhoneBookEntry {

    private String ownerName;
    private int countryCode;
    private int areaCode;
    private int number;

    public boolean equals(Object obj){
        if (!(obj instanceof PhoneBookEntry))
            return false;
        PhoneBookEntry entry = (PhoneBookEntry)obj;
        return ownerName.equals(entry.ownerName) &&
                countryCode == entry.countryCode &&
                areaCode == entry.areaCode &&
                number == entry.number;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int hashCode(){
        int hash = 37;
        hash = hash * 17 + ownerName.hashCode();
        hash = hash * 17 + countryCode;
        hash = hash * 17 + areaCode;
        hash = hash * 17 + number;
        return hash;
    }

    public static void main(String[] args) {
        PhoneBookEntry pbe = new PhoneBookEntry();
        pbe.ownerName = "Artur";
        pbe.areaCode = 1;
        pbe.countryCode = 2;
        pbe.number = 3;
        System.out.println(pbe.ownerName.hashCode());
        System.out.println(pbe.hashCode());
    }
}
