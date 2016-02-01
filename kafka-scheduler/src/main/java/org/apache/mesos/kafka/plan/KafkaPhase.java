package org.apache.mesos.kafka.plan;

import java.util.ArrayList;
import java.util.List;

import org.apache.mesos.kafka.config.KafkaConfigService;

public class KafkaPhase implements Phase {
  private KafkaConfigService config = null;

  public KafkaPhase(KafkaConfigService config) {
    this.config = config;
  }

  public List<Block> getBlocks() {
    List<Block> blocks = new ArrayList<Block>();

    for (int i=0; i<config.getBrokerCount(); i++) {
      blocks.add(new KafkaBlock(config, i));
    }

    return blocks;
  }

  public Block getCurrentBlock() {
    return null;
  }

  public boolean isComplete() {
    return false;
  }
}

