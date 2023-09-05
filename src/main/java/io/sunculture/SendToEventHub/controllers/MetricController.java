package io.sunculture.SendToEventHub.controllers;

import io.sunculture.SendToEventHub.models.Metric;
import io.sunculture.SendToEventHub.repositories.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/metric")
@RequiredArgsConstructor
public class MetricController {

    private final MetricRepository metricRepository;

    // todo:- persist data in dynamodb
    // todo:- delete data from dynamodb
    // todo:- fetch all data from dynamodb paged and sorted to fit required criteria
    // todo:- fetch single entry from dynamodb

    @PostMapping(path = "", produces = "application/json")
    public Metric saveMetric(@RequestBody Metric metric) {
        return metricRepository.save(metric);
    }

    @GetMapping(path = "/{deviceId}", produces = "application/json")
    public Metric getMetricById(@PathVariable String deviceId) {
        return metricRepository.getMetricByDeviceId(deviceId);
    }

    @DeleteMapping(path = "/{deviceId}", produces = "application/json")
    public String deleteMetricById(@PathVariable String deviceId) {
        return metricRepository.delete(deviceId);
    }
}
