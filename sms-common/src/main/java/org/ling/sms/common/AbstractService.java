package org.ling.sms.common;

public abstract class AbstractService implements Service {

  public enum STATE {NEW, INITED, STARTED, STOPPED}

  private STATE state;

  public AbstractService() {
    this.state = STATE.NEW;
  }

  public abstract void serviceInit();

  public void init() {
    serviceInit();
    if (this.state.equals(STATE.NEW)) {
      this.state = STATE.INITED;
    }

  }

  public abstract void serviceStart();

  public void start() {
    serviceStart();
    if (this.state.equals(STATE.INITED)) {
      this.state = STATE.STARTED;
    }
  }

  public void stop() {
    if (this.state.equals(STATE.STARTED)) {
      this.state = STATE.STOPPED;
    }
  }
}
