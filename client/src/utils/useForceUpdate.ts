import { useState } from "react";

/**
 * @returns A function that can be called to force an update of a functional component
 */
const useForceUpdate = (): VoidFunction => {
    const [, updateState] = useState({});
    return () => updateState({});
};

export default useForceUpdate;