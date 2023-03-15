package org.acme.deals;

import org.acme.deals.DealreviewsModel;

public class DealreviewsProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<DealreviewsModel> {

    public DealreviewsProcessInstance(org.acme.deals.DealreviewsProcess process, DealreviewsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public DealreviewsProcessInstance(org.acme.deals.DealreviewsProcess process, DealreviewsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public DealreviewsProcessInstance(org.acme.deals.DealreviewsProcess process, DealreviewsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public DealreviewsProcessInstance(org.acme.deals.DealreviewsProcess process, DealreviewsModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public DealreviewsProcessInstance(org.acme.deals.DealreviewsProcess process, DealreviewsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(DealreviewsModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(DealreviewsModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
