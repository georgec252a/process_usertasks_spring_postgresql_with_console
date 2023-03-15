/*
 * Copyright 2020 Red Hat, Inc. and/or its affiliates.
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
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "dealreviews", name = "Dealreviews", hidden = true)
@ProcessInput(processName = "dealreviews")
public class DealreviewsModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<DealreviewsModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "deal")
    @javax.validation.Valid()
    private java.lang.String deal;

    public java.lang.String getDeal() {
        return deal;
    }

    public void setDeal(java.lang.String deal) {
        this.deal = deal;
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
    public DealreviewsModel toModel() {
        DealreviewsModel result = new DealreviewsModel();
        result.setDeal(getDeal());
        result.setReview(getReview());
        result.setTraveller(getTraveller());
        return result;
    }
}