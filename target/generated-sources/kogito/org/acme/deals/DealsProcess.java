package org.acme.deals;

import org.acme.deals.DealsModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@org.springframework.stereotype.Component("deals")
public class DealsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.deals.DealsModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    @org.springframework.beans.factory.annotation.Qualifier("dealreviews")
    org.kie.kogito.process.Process<DealreviewsModel> processdealreviews;

    @org.springframework.beans.factory.annotation.Autowired()
    public DealsProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public DealsProcess() {
    }

    @Override()
    public org.acme.deals.DealsProcessInstance createInstance(org.acme.deals.DealsModel value) {
        return new org.acme.deals.DealsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.deals.DealsProcessInstance createInstance(java.lang.String businessKey, org.acme.deals.DealsModel value) {
        return new org.acme.deals.DealsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.deals.DealsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.acme.deals.DealsModel value) {
        return new org.acme.deals.DealsProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.acme.deals.DealsModel createModel() {
        return new org.acme.deals.DealsModel();
    }

    public org.acme.deals.DealsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.deals.DealsModel) value);
    }

    public org.acme.deals.DealsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.deals.DealsModel) value);
    }

    public org.acme.deals.DealsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.deals.DealsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealsProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("deals", true);
        factory.variable("name", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("review", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("traveller", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.travels.Traveller.class), null, "customTags", null);
        factory.name("SubmitDeal");
        factory.packageName("org.acme.deals");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.imports("org.acme.travels.Traveller");
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode1 = factory.endNode(1);
        endNode1.name("End Event 1");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_4583DB41-9B89-4729-AC8A-A0666534E616");
        endNode1.metaData("elementname", "End Event 1");
        endNode1.metaData("x", 939);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 154);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode2 = factory.actionNode(2);
        actionNode2.name("Print review of the deal");
        actionNode2.action(kcontext -> {
            java.lang.String review = (java.lang.String) kcontext.getVariable("review");
            org.acme.travels.Traveller traveller = (org.acme.travels.Traveller) kcontext.getVariable("traveller");
            System.out.println("Review of the deal " + review + " for traveller " + traveller.getLastName());
        });
        actionNode2.metaData("UniqueId", "_0BAE98AF-9B65-444E-9B84-E48A3B593DBE");
        actionNode2.metaData("elementname", "Print review of the deal");
        actionNode2.metaData("NodeType", "ScriptTask");
        actionNode2.metaData("x", 700);
        actionNode2.metaData("width", 154);
        actionNode2.metaData("y", 131);
        actionNode2.metaData("height", 102);
        actionNode2.done();
        org.jbpm.ruleflow.core.factory.SubProcessNodeFactory<?> subProcessNode3 = factory.subProcessNode(3);
        subProcessNode3.name("Call a deal");
        subProcessNode3.processId("dealreviews");
        subProcessNode3.processName("");
        subProcessNode3.waitForCompletion(true);
        subProcessNode3.independent(false);
        subProcessNode3.subProcessNode(new org.jbpm.workflow.core.node.SubProcessFactory<DealreviewsModel>() {

            public DealreviewsModel bind(org.kie.api.runtime.process.ProcessContext kcontext) {
                org.acme.deals.DealreviewsModel model = new org.acme.deals.DealreviewsModel();
                java.util.Map<java.lang.String, java.lang.Object> inputs = org.jbpm.workflow.core.impl.NodeIoHelper.processInputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
                model.update(inputs);
                return model;
            }

            public org.kie.kogito.process.ProcessInstance<DealreviewsModel> createInstance(DealreviewsModel model) {
                return processdealreviews.createInstance(model);
            }

            public void unbind(org.kie.api.runtime.process.ProcessContext kcontext, DealreviewsModel model) {
                java.util.Map<java.lang.String, java.lang.Object> outputs = new java.util.HashMap<java.lang.String, java.lang.Object>();
                outputs.put("review", model.getReview());
                org.jbpm.workflow.core.impl.NodeIoHelper.processOutputs((org.jbpm.workflow.instance.impl.NodeInstanceImpl) kcontext.getNodeInstance(), (java.lang.String name) -> {
                    return outputs.get(name);
                }, (java.lang.String name) -> {
                    return kcontext.getVariable(name);
                });
            }
        });
        subProcessNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("name", "name", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6_dealInputX", "deal", "java.lang.String", null), null, null));
        subProcessNode3.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6_travellerInputX", "traveller", "org.acme.travels.Traveller", null), null, null));
        subProcessNode3.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_C3082C6F-963E-40A2-B31B-1E8F336AA4C6_reviewOutputX", "review", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("review", "review", "java.lang.Object", null), null, null));
        subProcessNode3.metaData("UniqueId", "_C3082C6F-963E-40A2-B31B-1E8F336AA4C6");
        subProcessNode3.metaData("elementname", "Call a deal");
        subProcessNode3.metaData("x", 471);
        subProcessNode3.metaData("width", 154);
        subProcessNode3.metaData("y", 131);
        subProcessNode3.metaData("height", 102);
        subProcessNode3.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode4 = factory.startNode(4);
        startNode4.name("Start Proces");
        startNode4.interrupting(true);
        startNode4.metaData("UniqueId", "_CBED5120-F3EC-40A0-9A1F-072F37FA1204");
        startNode4.metaData("elementname", "Start Proces");
        startNode4.metaData("x", 335);
        startNode4.metaData("width", 56);
        startNode4.metaData("y", 154);
        startNode4.metaData("height", 56);
        startNode4.done();
        factory.connection(2, 1, "_BCF778A5-0959-49DA-B8FF-DB61025A7DD0");
        factory.connection(3, 2, "_A186F5CE-4300-4506-A89D-50DEDC8F24CF");
        factory.connection(4, 3, "_E3E55042-CEC7-4574-8315-068794ACBD69");
        factory.validate();
        return factory.getProcess();
    }

    protected void registerListeners() {
        services.getSignalManager().addEventListener("dealreviews", completionEventListener);
    }
}
