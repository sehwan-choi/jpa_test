package com.eduzone.jpastudy.study.encryt.annotaionbase_encrypt.spring_encryt;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 이 어노테이션을 추가한 필드는 Hibernate를 통해 INSERT/UPDATE 될떄 필드가 암호화 되며
 * SELECT 이후 필드가 복호화 되는 것을 나타낸다.
 *
 * <p>NOTE: 식별자 필드는 암호화/복호화를 할 수 없어 식별자가 아닌 필드에만 사용 해야 하며 필드의 타입은 반드시 {@link String}이어야 한다.
 *
 * <p>자세한 사용법은 아래와 같다.
 * <pre>
 *     &#064;Data
 *     &#064;NoArgsConstructor
 *     &#064;Entity
 *     public class TestEntity {
 *
 *         &#064;Id
 *         private String id;
 *
 *         &#64;Encrypted
 *         private String text;
 *     }
 * </pre>
 * <p>위와 같이 사용하면 <code>text</code> 필드는 테이블에 저장 되기 직전에 암호화 되며,
 * 데이터베이스에서 로드 직후 복호화가 된다.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Encrypted {

    /**
     * 암/복 호화에 사용할 클래스
     *
     * @return 암/복 호화에 사용할 클래스
     */
    String cryptoKey() default "";
}
