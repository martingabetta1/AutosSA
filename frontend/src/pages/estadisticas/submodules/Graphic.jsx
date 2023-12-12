import React from "react";
import Chart from "chart.js/auto";
import { Bar } from "react-chartjs-2";
import { useState } from "react";
import { useEffect } from "react";

const Graphic = ({ components, data }) => {

    const [graphicData, setGraphicData] = useState({})

    const constructGraphicData = () => {
        let labels = [],
            values = [],
            backgroundColor = [],
            borderColor = []

        for (let index in data) {
            let random = [Math.random() * (255 - 0) + 0,Math.random() * (255 - 0) + 0,Math.random() * (255 - 0) + 0]
            labels.push(data[index][components.keysAccess[0]])
            values.push(data[index][components.keysAccess[1]])
            borderColor.push(`rgba(${random[0]}, ${random[1]}, ${random[2]})`)
            backgroundColor.push(`rgba(${random[0]}, ${random[1]}, ${random[2]},0.7)`)
        }

        setGraphicData({
            labels: labels,
            datasets: [
                {
                    label: components.title,
                    backgroundColor: backgroundColor,
                    borderWidth:2,
                    borderColor: borderColor,
                    data: values
                },
            ],
        })
    }

    useEffect(() => {
        constructGraphicData()
    }, [data])

    return (
        <>
            <h3 style={{display:"table",color:"grey"}}>Gráfico de estadisticas</h3>
            {Object.keys(graphicData).length > 0 && (
                <Bar data={graphicData} />
            )}

        </>
    );
};

export { Graphic };