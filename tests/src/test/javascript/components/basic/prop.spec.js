import {expect} from 'chai'
import {
  createAndMountComponent, destroyComponent, onGwtReady,
  onNextTick
} from '../../vue-gwt-tests-utils'

describe('@Prop', () => {
  let component;

  beforeEach(() => onGwtReady().then(() => {
    component = createAndMountComponent(
        'com.axellience.vuegwt.tests.client.components.basic.prop.PropParentTestComponent');
  }));

  afterEach(() => {
    destroyComponent(component);
  });

  it('should have correct value at start', () => {
    const optionalPropDomValue = component.$el.querySelector(
        "#optional-prop").innerText;
    const requiredPropDomValue = component.$el.querySelector(
        "#required-prop").innerText;

    expect(optionalPropDomValue).to.equal('6');
    expect(requiredPropDomValue).to.equal('');
  });

  it('should have correct value when its passed value changes', () => {
    component.optionalPropParent = 16;
    component.requiredPropParent.setStringProperty("value");

    return onNextTick(() => {
      const optionalPropDomValue = component.$el.querySelector(
          "#optional-prop").innerText;
      const requiredPropDomValue = component.$el.querySelector(
          "#required-prop").innerText;

      expect(optionalPropDomValue).to.equal('16');
      expect(requiredPropDomValue).to.equal('value');
    });
  });
});