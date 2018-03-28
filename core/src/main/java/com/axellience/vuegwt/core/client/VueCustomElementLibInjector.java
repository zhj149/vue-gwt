package com.axellience.vuegwt.core.client;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLScriptElement;
import jsinterop.base.JsPropertyMap;

class VueCustomElementLibInjector
{
    static void ensureInjected()
    {
        if (isCustomElementInjected())
            return;

        HTMLScriptElement scriptElement =
            (HTMLScriptElement) DomGlobal.document.createElement("script");
        scriptElement.text = VUE_CUSTOM_ELEMENT;
        DomGlobal.document.body.appendChild(scriptElement);
    }

    private static boolean isCustomElementInjected()
    {
        return ((JsPropertyMap) DomGlobal.window).get("VueCustomElement") != null;
    }

    /**
     * vue-custom-element v1.4.2
     * (c) 2017 Karol Fabjańczuk
     * Modified by Adrien Baron
     * @license MIT
     */
    private static String VUE_CUSTOM_ELEMENT = "!function(e,t){\"object\"==typeof exports&&\"undefined\"!=typeof module?module.exports=t():\"function\"==typeof define&&define.amd?define(t):e.VueCustomElement=t()}(this,function(){\"use strict\";function e(e,t){return e.__proto__=t,e}function t(e,t){if(!e)throw new ReferenceError(\"this hasn't been initialised - super() hasn't been called\");return!t||\"object\"!=typeof t&&\"function\"!=typeof t?e:t}function n(){return Reflect.construct(HTMLElement,[],this.__proto__.constructor)}function o(e){function o(){!0===i.shadow&&HTMLElement.prototype.attachShadow&&this.attachShadow({mode:\"open\"}),i.constructorCallback.call(this,this)}function r(){i.connectedCallback.call(this,this)}function c(){i.disconnectedCallback.call(this,this)}function a(e,t,n){i.attributeChangedCallback.call(this,e,t,n,this)}var i=arguments.length>1&&void 0!==arguments[1]?arguments[1]:{};if(\"undefined\"!=typeof customElements){if(f){var u=function(e){function r(e){var n;!function(e,t){if(!(e instanceof t))throw new TypeError(\"Cannot call a class as a function\")}(this,r);var c=t(this,(r.__proto__||Object.getPrototypeOf(r)).call(this)),a=e?HTMLElement.call(e):c;return o.call(a),n=a,t(c,n)}return function(e,t){if(\"function\"!=typeof t&&null!==t)throw new TypeError(\"Super expression must either be null or a function, not \"+typeof t);e.prototype=Object.create(t&&t.prototype,{constructor:{value:e,enumerable:!1,writable:!0,configurable:!0}}),t&&(Object.setPrototypeOf?Object.setPrototypeOf(e,t):e.__proto__=t)}(r,n),d(r,null,[{key:\"observedAttributes\",get:function(){return i.observedAttributes||[]}}]),r}();return u.prototype.connectedCallback=r,u.prototype.disconnectedCallback=c,u.prototype.attributeChangedCallback=a,customElements.define(e,u),u}var l=function(e){var t=e?HTMLElement.call(e):this;return o.call(t),t};return l.observedAttributes=i.observedAttributes||[],l.prototype=Object.create(HTMLElement.prototype,{constructor:{configurable:!0,writable:!0,value:l}}),l.prototype.connectedCallback=r,l.prototype.disconnectedCallback=c,l.prototype.attributeChangedCallback=a,customElements.define(e,l),l}}function r(e){for(var t=arguments.length>1&&void 0!==arguments[1]?arguments[1]:0,n=e.length-t,o=new Array(n);n--;)o[n]=e[n+t];return o}function c(e){var t=e,n=[\"true\",\"false\"].indexOf(e)>-1,o=parseFloat(t,10),r=!isNaN(o)&&isFinite(t);return n?t=\"true\"===t:r&&(t=o),t}function a(e,t){if(e&&e.length)e.forEach(function(e){var n=h(e);-1===t.camelCase.indexOf(n)&&t.camelCase.push(n)});else if(e&&\"object\"===(void 0===e?\"undefined\":m(e)))for(var n in e){var o=h(n);-1===t.camelCase.indexOf(o)&&t.camelCase.push(o)}}function i(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:[],t=arguments[1],n=[];return r(e).forEach(function(e){if(\"#text\"===e.nodeName)e.nodeValue.trim()&&n.push(t(\"span\",e.nodeValue));else if(\"#comment\"!==e.nodeName){var o=function(e){var t={};return r(e.attributes).forEach(function(e){t[\"vue-slot\"===e.nodeName?\"slot\":e.nodeName]=e.nodeValue}),t}(e),c={attrs:o,domProps:{innerHTML:e.innerHTML}};o.slot&&(c.slot=o.slot,o.slot=void 0),n.push(t(e.tagName,c))}}),n}function u(e,t){for(var n=arguments.length,o=Array(n>2?n-2:0),r=2;r<n;r++)o[r-2]=arguments[r];var c=function(e,t){var n={bubbles:!1,cancelable:!1,detail:t},o=void 0;return\"function\"==typeof window.CustomEvent?o=new CustomEvent(e,n):(o=document.createEvent(\"CustomEvent\")).initCustomEvent(e,n.bubbles,n.cancelable,n.detail),o}(t,[].concat(o));e.dispatchEvent(c)}function l(e,t,n,o,r){if(!e.__vue_custom_element__){var a=function(e,t,n){var o=t.propsData||{};return n.hyphenate.forEach(function(t,r){var a=e.attributes[t],i=n.camelCase[r];\"object\"!==(void 0===a?\"undefined\":m(a))||a instanceof Attr?a instanceof Attr&&a.value&&(o[i]=c(a.value)):o[i]=a}),o}(e,n.options,o),l=n.extend({beforeCreate:function(){this.$emit=function(){for(var t,n=arguments.length,o=Array(n),r=0;r<n;r++)o[r]=arguments[r];u.apply(void 0,[e].concat(o)),this.__proto__&&(t=this.__proto__.$emit).call.apply(t,[this].concat(o))}}}),s=e.cloneNode(!0).childNodes,f={propsData:a,props:o.camelCase,computed:{reactiveProps:function(){var e=this,t={};return o.camelCase.forEach(function(n){t[n]=e[n]}),t}},render:function(e){var t={props:this.reactiveProps};return e(l,t,i(s,e))}};if(r.shadow&&e.shadowRoot?(e.shadowRoot.innerHTML=\"<div></div>\",f.el=e.shadowRoot.children[0]):(e.innerHTML=\"<div></div>\",f.el=e.children[0]),function(e,t){t.camelCase.forEach(function(n,o){Object.defineProperty(e,n,{get:function(){return this.__vue_custom_element__[n]},set:function(e){if(\"object\"!==(void 0===e?\"undefined\":m(e))&&\"function\"!=typeof e||!this.__vue_custom_element__)this.setAttribute(t.hyphenate[o],c(e));else{var n=t.camelCase[o];this.__vue_custom_element__[n]=e}}})})}(e,o),e.__vue_custom_element__=new t(f),r.shadow&&r.shadowCss&&e.shadowRoot){var d=document.createElement(\"style\");d.type=\"text/css\",d.appendChild(document.createTextNode(r.shadowCss)),e.shadowRoot.appendChild(d)}e.removeAttribute(\"vce-cloak\"),e.setAttribute(\"vce-ready\",\"\"),u(e,\"vce-ready\")}}function s(e){e.customElement=function(t,n){var r=arguments.length>2&&void 0!==arguments[2]?arguments[2]:{},i=function(e){var t={camelCase:[],hyphenate:[]},n=e.options;return n?(n.mixins&&n.mixins.forEach(function(e){a(e.props,t)}),a(n.props,t),t.camelCase.forEach(function(e){t.hyphenate.push(b(e))}),t):t}(n);return o(t,{constructorCallback:function(e){\"function\"==typeof r.constructorCallback&&r.constructorCallback.call(this,e)},connectedCallback:function(t){this.__detached__||l(this,e,n,i,r),\"function\"==typeof r.connectedCallback&&r.connectedCallback.call(this,t),this.__detached__=!1},disconnectedCallback:function(e){var t=this;this.__detached__=!0,\"function\"==typeof r.disconnectedCallback&&r.disconnectedCallback.call(this,e),setTimeout(function(){t.__detached__&&t.__vue_custom_element__&&t.__vue_custom_element__.$destroy(!0)},r.destroyTimeout||3e3)},attributeChangedCallback:function(e,t,n,o){if(this.__vue_custom_element__&&void 0!==n){var a=h(e);\"function\"==typeof r.attributeChangedCallback&&r.attributeChangedCallback.call(this,o,e,t,n),this.__vue_custom_element__[a]=c(n)}},observedAttributes:i.hyphenate,shadow:!!r.shadow&&!!HTMLElement.prototype.attachShadow})}}Object.setPrototypeOf=Object.setPrototypeOf||e;e.bind(Object);var f=\"undefined\"!=typeof Symbol&&\"undefined\"!=typeof Reflect,d=function(){function e(e,t){for(var n=0;n<t.length;n++){var o=t[n];o.enumerable=o.enumerable||!1,o.configurable=!0,\"value\"in o&&(o.writable=!0),Object.defineProperty(e,o.key,o)}}return function(t,n,o){return n&&e(t.prototype,n),o&&e(t,o),t}}();Object.setPrototypeOf(n.prototype,HTMLElement.prototype),Object.setPrototypeOf(n,HTMLElement);var p=/-(\\w)/g,h=function(e){return e.replace(p,function(e,t){return t?t.toUpperCase():\"\"})},_=/([^-])([A-Z])/g,b=function(e){return e.replace(_,\"$1-$2\").replace(_,\"$1-$2\").toLowerCase()},m=\"function\"==typeof Symbol&&\"symbol\"==typeof Symbol.iterator?function(e){return typeof e}:function(e){return e&&\"function\"==typeof Symbol&&e.constructor===Symbol&&e!==Symbol.prototype?\"symbol\":typeof e};return s.createElement=function(e){return new e},\"undefined\"!=typeof window&&window.Vue&&(window.Vue.use(s),s.installed&&(s.installed=!1)),s});";
}