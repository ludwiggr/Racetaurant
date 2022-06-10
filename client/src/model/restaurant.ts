import Cuisine, { isCuisine } from "./cuisine";
import Location, { isLocation } from "./location";
import OpeningTimes, { isOpeningTimes } from "./openingTimes";
import PriceCategory, { isPriceCategory } from "./priceCategory";
import RestaurantLayout, { isRestaurantLayout } from "./restaurantLayout";

/**
 * A Restaurant with the affiliated information
 */
class Restaurant {
    id: string;
    name: string;
    website: string;
    rating: number;
    images: Array<string>;
    priceCategory: PriceCategory;
    cuisines: Array<Cuisine>;
    location: Location;
    layout: RestaurantLayout;
    open: OpeningTimes;


    constructor(
        id: string,
        name: string,
        website: string,
        rating: number,
        images: Array<string>,
        priceCategory: PriceCategory,
        cuisines: Array<Cuisine>,
        location: Location,
        layout: RestaurantLayout,
        open: OpeningTimes
    ) {
        this.id = id
        this.name = name
        this.website = website
        this.rating = rating
        this.images = images
        this.priceCategory = priceCategory
        this.cuisines = cuisines
        this.location = location
        this.layout = layout
        this.open = open
    }

}

export default Restaurant;

/**
 * Checks if an object is a {@link Restaurant}
 * @param restaurant the object to check
 * @returns `true` if the given value is a {@link Restaurant}, `false` otherwise
 */
export const isRestaurant = (restaurant: any): restaurant is Restaurant => {
    return (typeof restaurant === "object") && //
        (typeof restaurant.id === "string") && //
        (typeof restaurant.name === "string") && //
        (typeof restaurant.website === "string") && //
        (typeof restaurant.rating === "number") && //
        (Array.isArray(restaurant.images)) && ((restaurant.images as Array<any>).every(i => typeof i === "string")) && //
        (isPriceCategory(restaurant.priceCategory)) && //
        (Array.isArray(restaurant.cuisines)) && ((restaurant.cuisines as Array<any>).every(isCuisine)) && //
        (isLocation(restaurant.location)) && //
        (isRestaurantLayout(restaurant.layout)) && //
        (isOpeningTimes(restaurant.open));
};

/**
 * Checks if an object is an array of {@link Restaurant}s
 * @param restaruants the object to check
 * @returns `true` if the given value is an array of {@link Restaurant}s, `false` otherwise
 */
export const isRestaurantArray = (restaurants: any): restaurants is Array<Restaurant> => {
    return (Array.isArray(restaurants)) && ((restaurants).every(isRestaurant));
}