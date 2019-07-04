package com.example.springbootrest;

import java.io.Serializable;

public class FileAttachmentMerged implements Serializable {
    private String strName;
    private String strUploadedDate;
    private String strUploadedBy;
    private String strContentType;

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getStrUploadedDate() {
        return strUploadedDate;
    }

    public void setStrUploadedDate(String strUploadedDate) {
        this.strUploadedDate = strUploadedDate;
    }

    public String getStrUploadedBy() {
        return strUploadedBy;
    }

    public void setStrUploadedBy(String strUploadedBy) {
        this.strUploadedBy = strUploadedBy;
    }

    public String getStrContentType() {
        return strContentType;
    }

    public void setStrContentType(String strContentType) {
        this.strContentType = strContentType;
    }
}
