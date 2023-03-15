/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.acme.deals;

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "deals", name = "Deals", hidden = true)
public class DealsModelOutput implements org.kie.kogito.Model, MapInput, MapInputId, MapOutput, MappableToModel<DealsModel> {

    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "review")
    @javax.validation.Valid()
    private java.lang.String review;

    public java.lang.String getReview() {
        return review;
    }

    public void setReview(java.lang.String review) {
        this.review = review;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "name")
    @javax.validation.Valid()
    private java.lang.String name;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "traveller")
    @javax.validation.Valid()
    private org.acme.travels.Traveller traveller;

    public org.acme.travels.Traveller getTraveller() {
        return traveller;
    }

    public void setTraveller(org.acme.travels.Traveller traveller) {
        this.traveller = traveller;
    }

    @Override()
    public DealsModel toModel() {
        DealsModel result = new DealsModel();
        result.setId(getId());
        result.setReview(getReview());
        result.setName(getName());
        result.setTraveller(getTraveller());
        return result;
    }
}
