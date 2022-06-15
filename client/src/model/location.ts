/**
 * A Location given by a latitude and a longitude, as well as a human-readable address
 */
class Location {
    latitude: number;
    longitude: number;
    address: string;

    constructor(latitude: number, longitude: number, address: string) {
        this.latitude = latitude
        this.longitude = longitude
        this.address = address
    }

}

export default Location;

/**
 * Checks if an object is a {@link Location}
 * @param location the object to check
 * @returns `true` if the given value is a {@link Location}, `false` otherwise
 */
export const isLocation = (location: any): location is Location => {
    return (typeof location === "object") && //
        (typeof location.latitude === "number") && //
        (typeof location.longitude === "number") && //
        (typeof location.address === "string");
};