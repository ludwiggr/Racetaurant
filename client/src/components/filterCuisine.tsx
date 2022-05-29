import Box from '@mui/material/Box';
import Chip from '@mui/material/Chip';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import OutlinedInput from '@mui/material/OutlinedInput';
import Select from '@mui/material/Select';
import { Theme, useTheme } from '@mui/material/styles';
import React from 'react';
import Cuisine, { isCuisine } from '../model/cuisine';


function getStyles(name: string, personName: readonly string[], theme: Theme) {
    return {
        fontWeight:
            personName.indexOf(name) === -1
                ? theme.typography.fontWeightRegular
                : theme.typography.fontWeightMedium,
    };
}

const FilterCuisine: React.FC<{ cuisines: Array<Cuisine>, setCuisines: (cuisines: Array<Cuisine>) => void }> = ({ cuisines, setCuisines }) => {
    const theme = useTheme();

    //Build cuisineFilter
    const renderFilterCuisine = (): JSX.Element => {
        return <FormControl sx={{ m: 1, width: 300 }}>
            <InputLabel id="multiple-cuisines-label">Cuisine</InputLabel>
            <Select
                labelId="multiple-cuisines-label"
                id="multiple-cuisines"
                multiple
                value={cuisines}
                onChange={(e) => {
                    if (e.target.value instanceof Array<Cuisine>)
                        setCuisines(e.target.value);
                    if (isCuisine(e.target.value))
                        setCuisines([e.target.value]);
                }}
                input={<OutlinedInput id="multiple-cuisines" label="cuisine" />}
                renderValue={(selected) => (
                    <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
                        {selected.map((value) => (
                            <Chip key={value} label={value} />
                        ))}
                    </Box>
                )}
            >
                {(Object.keys(Cuisine) as Array<keyof typeof Cuisine>).map((name) => (
                    <MenuItem
                        key={name}
                        value={name}
                        style={getStyles(name, cuisines, theme)}
                    >
                        {name}
                    </MenuItem>
                ))}
            </Select>
        </FormControl >
    }

    return (
        renderFilterCuisine()
    );
}

export default FilterCuisine
