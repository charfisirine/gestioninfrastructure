package com.stage.GestionInfarstructure.service;


import com.stage.GestionInfarstructure.domain.Application;
import com.stage.GestionInfarstructure.domain.Cluster;
import com.stage.GestionInfarstructure.repository.ApplicationRepository;
import com.stage.GestionInfarstructure.repository.ClusterRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

@Service
public class ClusterService {

    @Autowired
    private ClusterRepository clusterRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Transactional
    public void addApplicationsToCluster(Integer clusterId, Collection<Integer> applicationIds) {
        // Find the cluster by ID

        Cluster cluster = clusterRepository.findById(clusterId)
                .orElseThrow(() -> new RuntimeException("Cluster not found"));

        // Find the applications by their IDs

        Collection<Application> applications = applicationRepository.findAllById(applicationIds);
        // Set the applications to the cluster

        cluster.setApplications(new HashSet<>(applications));
        // Save the updated cluster

        clusterRepository.save(cluster);
    }

}

