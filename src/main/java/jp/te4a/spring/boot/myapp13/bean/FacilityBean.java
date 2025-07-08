package jp.te4a.spring.boot.myapp13.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "facilities")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacilityBean {
    @Id
    @GeneratedValue
    private Integer id ;
    @Column(nullable = false)
    private String title;
    private String writter;
    private String publisher;
    private Integer price;

    /*private Integer no;

    private String pro_name; //品名
    private String model_no; //型番
    private String maker; //メーカ
    private String siyou; //仕様
    private Integer t_year; //耐用年数
    private Integer date; //購入日
    private String genka_syoukyaku; //減価償却
    private boolean useable; //使用可能
    private boolean lentable; //貸出可能
    private String place; //設置場所
    private Integer limit; //使用期限*/
}
