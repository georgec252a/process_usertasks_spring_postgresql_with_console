package org.acme.deals;

import org.acme.deals.DealsModel;

public class DealsProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<DealsModel> {

    public DealsProcessInstance(org.acme.deals.DealsProcess process, DealsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public DealsProcessInstance(org.acme.deals.DealsProcess process, DealsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public DealsProcessInstance(org.acme.deals.DealsProcess process, DealsModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public DealsProcessInstance(org.acme.deals.DealsProcess process, DealsModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public DealsProcessInstance(org.acme.deals.DealsProcess process, DealsModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(DealsModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(DealsModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
