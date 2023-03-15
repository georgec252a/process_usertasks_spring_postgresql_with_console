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

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "review", processName = "dealreviews")
public class Dealreviews_2_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("review", this.review);
        return params;
    }

    public static Dealreviews_2_TaskOutput fromMap(Map<String, Object> params) {
        org.acme.deals.Dealreviews_2_TaskOutput result = new Dealreviews_2_TaskOutput();
        result.review = (java.lang.String) params.get("review");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private java.lang.String review;

    public java.lang.String getReview() {
        return review;
    }

    public void setReview(java.lang.String review) {
        this.review = review;
    }
}
// Task output for user task 'Review the deal' in process 'dealreviews'
