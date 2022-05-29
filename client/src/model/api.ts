import Restaurant from "./restaurant"
import PriceCategory from "./priceCategory";
import Cuisine from "./cuisine";
import axios from "axios";

export type FilterOptions = {
    price?: PriceCategory,
    latitude?: number,
    longitude?: number,
    radius?: number,
    cuisines?: Array<Cuisine>,
    rating_min?: number,
    rating_max?: number,
    time_start?: Date,
    time_stop?: Date,
    persons?: number,
}

const getRestaurants = (filter?: FilterOptions, start?: number, limit?: number, order?: "id" | "name" | "rating", asc?: boolean): Promise<Array<Restaurant>> => {
    return new Promise((resolve, reject) => {
        axios.get("/api/restaurants", {
            params: { ...filter, start: start, limit: limit, order: order, asc: asc }
        }).then(result => resolve(result.data as Array<Restaurant>)).catch(reject);
    });
}

const getRestaurantById = (id: string): Promise<Restaurant> => {
    return new Promise((resolve, reject) => {
        axios.get(`/api/restaurants/${encodeURIComponent(id)}`).then(result => resolve(result.data as Restaurant)).catch(reject);
    });
}

export { getRestaurants, getRestaurantById };