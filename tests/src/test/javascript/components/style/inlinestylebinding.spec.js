import {expect} from 'chai'
import {
  createAndMountComponent,
  destroyComponent,
  getElement,
  nextTick,
  onGwtReady
} from '../../vue-gwt-tests-utils'

describe('Inline style binding', () => {
  let component;

  beforeEach(() => onGwtReady().then(() => {
    component = createAndMountComponent(
        'com.axellience.vuegwt.tests.client.components.style.inlinestylebinding.InlineStyleBindingTestComponent');
  }));

  afterEach(() => {
    destroyComponent(component);
  });

  it('should work with single map entry', () => {
    const element = getElement(component, '#map-single');
    expect(element.getAttribute('style')).to.equal('color: black;');

    component.setColor('white');
    return nextTick().then(() => {
      expect(element.getAttribute('style')).to.equal('color: white;');
    });
  });

  it('should work with multiple map entries', () => {
    const element = getElement(component, '#map-multiple');
    const styleAttribute = element.getAttribute('style');
    expect(styleAttribute).to.have.string('color: black;');
    expect(styleAttribute).to.have.string('font-size: 12px;');

    component.setColor('white');
    component.setFontSize(14);
    return nextTick().then(() => {
      const styleAttribute = element.getAttribute('style');
      expect(styleAttribute).to.have.string('color: white;');
      expect(styleAttribute).to.have.string('font-size: 14px;');
    });
  });

  it('should work with array when a style is overridden', () => {
    const element = getElement(component, '#array-override');
    expect(element.getAttribute('style')).to.have.string('color: black;');
  });

  it('should work with multiple vendor prefixed values', () => {
    const element = getElement(component, '#array-multiple-values');
    expect(element.getAttribute('style')).to.equal('display: flex;');
  });
});