package OOTD.demo.dress;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 옷 카테고리 enum 클래스입니다.
 * TODO : 추후 카테고리 확정 후 데이터 추가
 *
 * @version 1.0.0
 * @author CHO Min Ho
 */
public enum DressType {
   OUTER("OUTER"),
   TOP("TOP"),
   BOTTOMS("BOTTOMS"),
   SHOES("SHOES");

   private String value;

   DressType(String value) {
      this.value = value;
   }

   @JsonCreator
   public static DressType from(String value) {
      for (DressType dressType : DressType.values()) {
         if (dressType.getValue().equals(value)) {
            return dressType;
         }
      }
      return null;
   }

   @JsonValue
   public String getValue() {
      return value;
   }
}
