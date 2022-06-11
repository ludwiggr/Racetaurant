import Box from '@mui/material/Box';
import Chip from '@mui/material/Chip';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import OutlinedInput from '@mui/material/OutlinedInput';
import Select from '@mui/material/Select';
import React, { CSSProperties } from 'react';
import Cuisine, { isCuisine } from '../model/cuisine';


const FilterCuisine: React.FC<{ style: CSSProperties, cuisines: Array<Cuisine>, setCuisines: (cuisines: Array<Cuisine>) => void }> = ({ style, cuisines, setCuisines }) => {
    return (
        <FormControl fullWidth style={style} >
            <InputLabel id="multiple-cuisines-label">Cuisine</InputLabel>
            <Select
                labelId="multiple-cuisines-label"
                id="multiple-cuisines"
                multiple
                value={cuisines}
                onChange={e => {
                    if (Array.isArray(e.target.value))
                        setCuisines(e.target.value);
                    if (isCuisine(e.target.value))
                        setCuisines([e.target.value]);
                }}
                style={{ height: '100%' }}
                input={<OutlinedInput id="multiple-cuisines" label="cuisine" />}
                renderValue={(selected) => (
                    <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
                        {selected.map((value) => (
                            <Chip key={value} label={value} />
                        ))}
                    </Box>
                )}
            >
                {(Object.keys(Cuisine) as Array<keyof typeof Cuisine>).map(name =>
                    <MenuItem key={name} value={name}>{name}</MenuItem>
                )}
            </Select>
        </FormControl >
    );
}

export default FilterCuisine;
