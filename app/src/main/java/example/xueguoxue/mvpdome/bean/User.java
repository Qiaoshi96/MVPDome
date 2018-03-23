package example.xueguoxue.mvpdome.bean;

/**
 * Created by xueguoxue on 2018/3/23.
 * {
 "ret": 1,
 "start": -1,
 "end": -1,
 "country": "中国",
 "province": "北京",
 "city": "北京",
 "district": "",
 "isp": "",
 "type": "",
 "desc": ""
 }
 */

public class User {
    private String country;
    private String province;
    private String city;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
