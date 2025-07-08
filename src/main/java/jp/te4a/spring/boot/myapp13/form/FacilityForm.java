package jp.te4a.spring.boot.myapp13.form;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jp.te4a.spring.boot.myapp13.validate.TestValid;
import jp.te4a.spring.boot.myapp13.validate.Writter;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FacilityForm {
    private Integer id;
    @NotNull
    //@Size(min= 3)
    //@TestValid(param = "abc")
    private String title;
    @Size(min= 3,max = 20)
    //@Writter(ok = "東北タロウ")
    private String writter;
    private String publisher;
    //@Min(0)
    private Integer price;

    private Integer no;

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
    private Integer limit; //使用期限
}
