package com.gml.cursomc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Log implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLog;
    private Integer status;
    private String  msg;

    @UpdateTimestamp
    private Date timeStamp;

    public Log(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
        this.timeStamp = timeStamp;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Log)) return false;
        Log log = (Log) o;
        return Objects.equals(getIdLog(), log.getIdLog()) &&
                Objects.equals(getStatus(), log.getStatus()) &&
                Objects.equals(getMsg(), log.getMsg()) &&
                Objects.equals(getTimeStamp(), log.getTimeStamp());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getIdLog(), getStatus(), getMsg(), getTimeStamp());
    }

    @Override
    public String toString() {
        return "Log{" +
                "idLog=" + idLog +
                ", status=" + status +
                ", msg='" + msg + '\'' +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
