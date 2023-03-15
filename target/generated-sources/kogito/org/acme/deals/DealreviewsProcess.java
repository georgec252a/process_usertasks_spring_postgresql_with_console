package org.acme.deals;

import org.acme.deals.DealreviewsModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@org.springframework.stereotype.Component("dealreviews")
public class DealreviewsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.deals.DealreviewsModel> {

    @org.springframework.beans.factory.annotation.Autowired()
    public DealreviewsProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public DealreviewsProcess() {
    }

    @Override()
    public org.acme.deals.DealreviewsProcessInstance createInstance(org.acme.deals.DealreviewsModel value) {
        return new org.acme.deals.DealreviewsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(java.lang.String businessKey, org.acme.deals.DealreviewsModel value) {
        return new org.acme.deals.DealreviewsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.acme.deals.DealreviewsModel value) {
        return new org.acme.deals.DealreviewsProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.acme.deals.DealreviewsModel createModel() {
        return new org.acme.deals.DealreviewsModel();
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.deals.DealreviewsModel) value);
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.deals.DealreviewsModel) value);
    }

    public org.acme.deals.DealreviewsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealreviewsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.deals.DealreviewsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.deals.DealreviewsProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("dealreviews", true);
        factory.variable("deal", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("review", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), null, "customTags", null);
        factory.variable("traveller", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.acme.travels.Traveller.class), null, "customTags", null);
        factory.name("Deal Review");
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
        endNode1.metaData("UniqueId", "_AF59D427-38A9-4D28-B283-5916E2DABB2F");
        endNode1.metaData("elementname", "End Event 1");
        endNode1.metaData("x", 757);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 315);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode2 = factory.humanTaskNode(2);
        humanTaskNode2.name("Review the deal");
        humanTaskNode2.workParameter("NodeName", "Review the deal");
        humanTaskNode2.workParameter("TaskName", "review");
        humanTaskNode2.workParameter("Skippable", "true");
        humanTaskNode2.workParameter("ActorId", "john");
        humanTaskNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("review", "review", "java.lang.Object", null), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("deal", "deal", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_dealInputX", "deal", "java.lang.String", null), null, null));
        humanTaskNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("traveller", "traveller", "java.lang.Object", null)), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_travellerInputX", "traveller", "org.acme.travels.Traveller", null), null, null));
        humanTaskNode2.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d57a7303-a484-4b75-870b-3be30f381d78", "EXPRESSION (true)", "java.lang.Object", "true"), new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode2.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_3597E33A-1C00-41B3-924E-09EA47F79D93_reviewOutputX", "review", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("review", "review", "java.lang.Object", null), null, null));
        humanTaskNode2.done();
        humanTaskNode2.metaData("UniqueId", "_3597E33A-1C00-41B3-924E-09EA47F79D93");
        humanTaskNode2.metaData("elementname", "Review the deal");
        humanTaskNode2.metaData("x", 523);
        humanTaskNode2.metaData("width", 154);
        humanTaskNode2.metaData("y", 292);
        humanTaskNode2.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode3 = factory.startNode(3);
        startNode3.name("Start Process");
        startNode3.interrupting(true);
        startNode3.metaData("UniqueId", "_7E3D27D0-6644-4E55-8E41-9F68BD0D1327");
        startNode3.metaData("elementname", "Start Process");
        startNode3.metaData("x", 387);
        startNode3.metaData("width", 56);
        startNode3.metaData("y", 315);
        startNode3.metaData("height", 56);
        startNode3.done();
        factory.connection(2, 1, "_EECDD765-E29C-4D34-B390-25A729F40206");
        factory.connection(3, 2, "_0EF9197C-8AD7-422D-BE5F-E01CF996E44F");
        factory.validate();
        return factory.getProcess();
    }
}
