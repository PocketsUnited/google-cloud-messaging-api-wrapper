/* * Copyright (c) 2012 Pockets United GmbH * *    Licensed under the Apache License, Version 2.0 (the "License"); *    you may not use this file except in compliance with the License. *    You may obtain a copy of the License at * *        http://www.apache.org/licenses/LICENSE-2.0 * *    Unless required by applicable law or agreed to in writing, software *    distributed under the License is distributed on an "AS IS" BASIS, *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. *    See the License for the specific language governing permissions and *    limitations under the License. */package com.pocketsunited.gcm.data;import com.fasterxml.jackson.annotation.JsonProperty;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.Map;/** * * * @author Michael Duergner <michael@pocketsunited.com> */public class Request extends AbstractJsonBase {    @JsonProperty(            value = "registration_ids")    protected List<String> registrationIds = new ArrayList<String>();    @JsonProperty(            value = "collapse_key")    protected String collapseKey;    @JsonProperty(            value = "data")    protected Map<String,String> data = new HashMap<String, String>();    @JsonProperty(            value = "delay_while_idle")    protected boolean delayWhileIdle = Boolean.FALSE;    @JsonProperty(            value = "time_to_live")    protected long timeToLive = 4l * 7l * 24l * 60l * 60l; // 4 weeks    @JsonProperty(            value = "category")    protected String category;    @JsonProperty(            value = "dry_run")    protected boolean dryRun = Boolean.FALSE;    public String getRegistrationId(int index) {        if (index < registrationIds.size()) {            return registrationIds.get(index);        }        throw new IllegalArgumentException("'index' is out of bounds!");    }    /**     *     *     * @author Michael Duergner <michael@pocketsunited.com>     */    protected static abstract class Init<T extends Init<T,U>, U extends Request> extends AbstractJsonBase.Init<T,U> {        protected Init(U object) {            super(object);        }        public T withRecipientId(String recipientId) {            object.registrationIds.add(recipientId);            return self();        }        public T withCollapseKey(String collapseKey) {            object.collapseKey = collapseKey;            return self();        }        public T withDataField(String key, String value) {            object.data.put(key,value);            return self();        }        public T withData(Map<String,String> data) {            object.data = data;            return self();        }        public T withDelayWhileIdle() {            object.delayWhileIdle = true;            return self();        }        public T withoutDelayWhileIdle() {            object.delayWhileIdle = false;            return self();        }        public T withTimeToLive(long timeToLive) {            object.timeToLive = timeToLive;            return self();        }        public T withCategory(String category) {            object.category = category;            return self();        }        public T withDryRun() {            object.dryRun = true;            return self();        }        public T withoutDryRun() {            object.dryRun = false;            return self();        }    }    /**     *     *     * @author Michael Duergner <michael@pocketsunited.com>     */    public static class Builder extends Init<Builder,Request> {        public Builder() {            super(new Request());        }        @Override        protected Builder self() {            return this;        }    }}