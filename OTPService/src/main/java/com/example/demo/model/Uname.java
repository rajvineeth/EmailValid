
package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Uname {

                @JsonProperty("result")
                private Integer result;
                @JsonProperty("emailId")
                private String emailId;
                @JsonProperty("account")
                private int account;
                @JsonIgnore
                private Map<String, Object> additionalProperties = new HashMap<String, Object>();
                
                
                public Uname(Integer result, String uname, int account, Map<String, Object> additionalProperties) {
                                super();
                                this.result = result;
                                this.emailId = uname;
                                this.account = account;
                                this.additionalProperties = additionalProperties;
                }
                public Uname() {
                                super();
                }
                public Integer getResult() {
                                return result;
                }
                public void setResult(Integer result) {
                                this.result = result;
                }
                
                
                public String getEmailId() {
                                return emailId;
                }
                public void setEmailId(String emailId) {
                                this.emailId = emailId;
                }
                public int getAccount() {
                                return account;
                }
                public void setAccount(int account) {
                                this.account = account;
                }
                public Map<String, Object> getAdditionalProperties() {
                                return additionalProperties;
                }
                public void setAdditionalProperties(Map<String, Object> additionalProperties) {
                                this.additionalProperties = additionalProperties;
                }

                /**
                * No args constructor for use in serialization
                * 
                 */
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
//            public Uname() {
//            }
//
//            /**
//            * 
//            * @param result
//            * @param uname
//            */
//            public Uname(Integer result, String uname) {
//                            super();
//                            this.result = result;
//                            this.uname = uname;
//            }
//
//            @JsonProperty("result")
//            public Integer getResult() {
//                            return result;
//            }
//
//            @JsonProperty("result")
//            public void setResult(Integer result) {
//                            this.result = result;
//            }
//
//            @JsonProperty("uname")
//            public String getUname() {
//                            return uname;
//            }
//
//            @JsonProperty("uname")
//            public void setUname(String uname) {
//                            this.uname = uname;
//            }
//
//            @JsonAnyGetter
//            public Map<String, Object> getAdditionalProperties() {
//                            return this.additionalProperties;
//            }
//
//            @JsonAnySetter
//            public void setAdditionalProperty(String name, Object value) {
//                            this.additionalProperties.put(name, value);
//            }
                
                
                
                
                
                

}
