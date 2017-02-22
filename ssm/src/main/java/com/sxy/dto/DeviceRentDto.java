package com.sxy.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class DeviceRentDto {



    private String companyName;
    private String tel;
    private String rentDate;
    private String linkMan;
    private String cardNum;
    private String address;
    private String fax;
    private String backDate;
    private Integer totalDate;
    private List<DeviceArrarBean> deviceArrar;
    private List<String> fileArray;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBackDate() {
        return backDate;
    }

    public void setBackDate(String backDate) {
        this.backDate = backDate;
    }

    public Integer getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(Integer totalDate) {
        this.totalDate = totalDate;
    }

    public List<DeviceArrarBean> getDeviceArrar() {
        return deviceArrar;
    }

    public void setDeviceArrar(List<DeviceArrarBean> deviceArrar) {
        this.deviceArrar = deviceArrar;
    }

    public List<String> getFileArray() {
        return fileArray;
    }

    public void setFileArray(List<String> fileArray) {
        this.fileArray = fileArray;
    }

    public static class DeviceArrarBean {
        /**
         * id : 4
         * name : 挖掘机
         * unit : 辆
         * price : 350
         * num : 2
         * total : 700
         */

        private Integer id;
        private String name;
        private String unit;
        private String price;
        private Integer num;
        private Float total;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Float getTotal() {
            return total;
        }

        public void setTotal(Float total) {
            this.total = total;
        }
    }
}
