package tomasn.lottery.mybatis.model;

import java.util.Date;

public class Draw {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRAW.DRAW_ID
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    private Integer drawId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRAW.NUMBERS
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    private String numbers;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DRAW.CLOSE_TIME
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    private Date closeTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRAW.DRAW_ID
     *
     * @return the value of PUBLIC.DRAW.DRAW_ID
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    public Integer getDrawId() {
        return drawId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRAW.DRAW_ID
     *
     * @param drawId the value for PUBLIC.DRAW.DRAW_ID
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    public void setDrawId(Integer drawId) {
        this.drawId = drawId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRAW.NUMBERS
     *
     * @return the value of PUBLIC.DRAW.NUMBERS
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    public String getNumbers() {
        return numbers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRAW.NUMBERS
     *
     * @param numbers the value for PUBLIC.DRAW.NUMBERS
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DRAW.CLOSE_TIME
     *
     * @return the value of PUBLIC.DRAW.CLOSE_TIME
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    public Date getCloseTime() {
        return closeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DRAW.CLOSE_TIME
     *
     * @param closeTime the value for PUBLIC.DRAW.CLOSE_TIME
     *
     * @mbg.generated Wed Apr 14 14:43:00 EEST 2021
     */
    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }
}