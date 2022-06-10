/**
 * The opening times for the different weekdays
 */
class OpeningTimes {
    monday: Time;
    tuesday: Time;
    wednesday: Time;
    thursday: Time;
    friday: Time;
    saturday: Time;
    sunday: Time;

    constructor(
        monday: Time,
        tuesday: Time,
        wednesday: Time,
        thursday: Time,
        friday: Time,
        saturday: Time,
        sunday: Time
    ) {
        this.monday = monday
        this.tuesday = tuesday
        this.wednesday = wednesday
        this.thursday = thursday
        this.friday = friday
        this.saturday = saturday
        this.sunday = sunday
    }

}

/**
 * A single time.
 * Either represented by a object with a start time and an end time (strings in local time, e.g. "10:00")
 * or by "closed".
 */
type Time = {
    from: string;
    to: string;
} | "closed";

export default OpeningTimes;

export type { Time };

/**
 * Checks if an object is a {@link Time}
 * @param time the object to check
 * @returns `true` if the given value is a {@link Time}, `false` otherwise
 */
export const isTime = (time: any): time is Time => {
    return ((typeof time === "string") && (time === "closed")) || //
        ((typeof time === "object") && (typeof time.from === "string") && (typeof time.to === "string"));
};

/**
 * Checks if an object is an {@link OpeningTimes}
 * @param openingTimes the object to check
 * @returns `true` if the given value is a {@link OpeningTimes}, `false` otherwise
 */
export const isOpeningTimes = (openingTimes: any): openingTimes is OpeningTimes => {
    return (typeof openingTimes === "object") && //
        ['monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday'].map(day => openingTimes[day]).every(isTime);
};