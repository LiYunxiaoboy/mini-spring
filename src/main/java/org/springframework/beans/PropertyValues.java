package org.springframework.beans;

import java.util.ArrayList;
import java.util.List;


public class PropertyValues {

	private final List<PropertyValue> propertyValueList = new ArrayList<>();
	//
	public void addPropertyValue(PropertyValue pv) {
		// 遍历每一个属性
		for (int i = 0; i < this.propertyValueList.size(); i++) {
			PropertyValue currentPv = this.propertyValueList.get(i);
			if (currentPv.getName().equals(pv.getName())) {
				//覆盖原有的属性值
				this.propertyValueList.set(i, pv);
				return;
			}
		}
		// 如果没有这项属性,就添加属性
		this.propertyValueList.add(pv);
	}

	public PropertyValue[] getPropertyValues() {
		return this.propertyValueList.toArray(new PropertyValue[0]);
	}

	public PropertyValue getPropertyValue(String propertyName) {
		for (int i = 0; i < this.propertyValueList.size(); i++) {
			PropertyValue pv = this.propertyValueList.get(i);
			if (pv.getName().equals(propertyName)) {
				return pv;
			}
		}
		return null;
	}
}