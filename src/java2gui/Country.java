package java2gui;

public enum Country {

    CANADA("Canada", "CA", "CAN", "124"),
    UNITED_KINGDOM("United Kingdom", "GB", "GBR", "826"),
    UNITED_STATES("United States", "US", "USA", "840"),
    INTERNATIONAL("INTERNATIONAL", "IN", "IN", "IN");
 
 
    private String countryName;
    private String A2Code;
    private String A3Code;
    private String NMCode;
 
    Country (String countryName, String A2Code, String A3Code, String NMCode) {
        this.countryName = countryName;
        this.A2Code = A2Code;
        this.A3Code = A3Code;
        this.NMCode = NMCode;
    }
 
    /**
     * Returns the ISO-3166 country name.
     *
     * @return {@link String}
     */
    public String getCountryName() {
        return countryName;
    }
 
    /**
     * Returns the ISO-3166 two character country code.
     *
     * @return {@link String}
     */
    public String getCountryCodeA2() {
        return A2Code;
    }
 
    /**
     * Returns the ISO-3166 three character country code.
     *
     * @return {@link String}
     */
    public String getCountryCodeA3() {
        return A3Code;
    }
 
    /**
     * Returns the ISO-3166 three digit numerical country code.
     *
     * @return {@link String}
     */
    public String getCountryCodeNM() {
        return NMCode;
    }
}


