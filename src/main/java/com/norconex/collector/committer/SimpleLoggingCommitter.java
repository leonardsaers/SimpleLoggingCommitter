/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norconex.collector.committer;

import com.norconex.committer.core.AbstractMappedCommitter;
import com.norconex.committer.core.IAddOperation;
import com.norconex.committer.core.ICommitOperation;
import java.util.List;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Simple committer which logs all commit operations.
 * 
 * @author leonard.saers
 */
public class SimpleLoggingCommitter extends AbstractMappedCommitter {

    private static final Logger LOG = 
            LogManager.getLogger(SimpleLoggingCommitter.class);

    public SimpleLoggingCommitter() {
        LOG.info("Initiate SimpleLoggingCommitter");
    }
    
    @Override
    protected void saveToXML(XMLStreamWriter writer) throws XMLStreamException {
    }

    @Override
    protected void loadFromXml(XMLConfiguration xmlc) {
    }

    @Override
    protected void commitBatch(List<ICommitOperation> batch) {
        for (ICommitOperation op : batch) {
            if (op instanceof IAddOperation) {
                LOG.info("Commit IAddOperation: " + ((IAddOperation) op).getReference());
            } else {
                LOG.info(op.toString());
            }
        }
    
    }
}
