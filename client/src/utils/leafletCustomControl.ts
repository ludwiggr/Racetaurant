import { createControlHook, createElementHook } from '@react-leaflet/core';
import { Control, ControlOptions, DomEvent, DomUtil } from 'leaflet';
import { forwardRef, useEffect, useState } from 'react';
import { createPortal } from 'react-dom';

// A custom control for adding React elements to Leaflet map

const CustomControl = Control.extend({
    options: {
        className: "",
    },
    onAdd() {
        let div = DomUtil.create("div", this.options.className);
        DomEvent.disableClickPropagation(div);
        return div;
    }
});

/**
 * @returns A function that can be called to force an update
 */
const useForceUpdate = (): VoidFunction => {
    const [, updateState] = useState(null);
    return () => updateState(null);
}


const createLeafletControl = <E extends Control, O extends ControlOptions>(element: any) => {
    const Component = (props: any, _ref: any) => {
        const forceUpdate = useForceUpdate();
        const { instance } = element(props).current;

        useEffect(() => {
            // https://github.com/LiveBy/react-leaflet-control/blob/master/lib/control.jsx
            // This is needed because the control is only attached to the map in
            // MapControl's componentDidMount, so the container is not available
            // until this is called. We need to now force a render so that the
            // portal and children are actually rendered.
            forceUpdate();
        }, []);

        const contentNode = instance.getContainer();
        return contentNode ? createPortal(props.children, contentNode) : null;
    }
    return forwardRef(Component);
}

export const ReactControl = createLeafletControl(createControlHook(createElementHook<Control, ControlOptions>((props, context) => ({
    instance: new CustomControl(props), context: context
}))));