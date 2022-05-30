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

type Time = {
    from: string;
    to: string;
} | "closed";

export default OpeningTimes;

export type { Time };

export const isTime = (time: any): time is Time => {
    return ((typeof time === "string") && (time === "closed")) || //
        ((typeof time === "object") && (typeof time.from === "string") && (typeof time.to === "string"));
};

export const isOpeningTimes = (openingTimes: any): openingTimes is OpeningTimes => {
    return (typeof openingTimes === "object") && //
        ['monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday'].map(day => openingTimes[day]).every(isTime);
};